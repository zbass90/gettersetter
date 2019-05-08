package gs.goott.intro;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gs.goott.content.ContentVO;
import gs.goott.util.DBConnection;

public class IntroDAO extends DBConnection implements IntroInterface {

	@Override
	public int introUpdate(IntroVO vo, String path) {
		int cnt = 0;
		String delFileName ="";
		String delThumbName ="";
		try {
			dbConn();
			String sql ="select filename, thumbnailFileName from introtbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				delFileName = rs.getString(1);
				delThumbName = rs.getString(2);
			}
			sql = "update introtbl set filename=?, interest=?, description=?, thumbnail=?, title=?, introdate=sysdate, thumbnailFileName=? where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getFilename());
			System.out.println(vo.getInterestStr().toLowerCase());
			pstmt.setString(2, vo.getInterestStr().toLowerCase());			
			pstmt.setString(3, vo.getDescription());
			pstmt.setString(4, vo.getThumbnail());
			System.out.println(vo.getTitle());
			pstmt.setString(5, vo.getTitle());
			System.out.println(vo.getUserid());
			pstmt.setString(6, vo.getThumbnailFileName());
			pstmt.setString(7, vo.getUserid());
			cnt = pstmt.executeUpdate();
			
			System.out.println("delFileName="+delFileName+"\ndelThumbName"+delThumbName);
			if(delFileName!=null && !delFileName.equals("")) {
				File f = new File(path,delFileName);
				File f2 = new File(path,delThumbName);
				if(vo.getBeforeFileName()==delFileName) {
					f.delete();
				}
				if(vo.getBeforeThumbnail()==delThumbName) {
					f2.delete();
				}
			}
		}catch(Exception e) {
			System.out.println("intro insert error"+e.getMessage());
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}

	@Override
	public IntroVO selectIntroVO(String userid) {
		IntroVO vo = new IntroVO();
		try {
			dbConn();
			String sql = "select introno, userid, filename, interest, description, to_char(introdate, 'YYYY-MM-DD'), title, follower, price, thumbnail from introtbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIntroNo(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setFilename(rs.getString(3));
				vo.setInterestStr(rs.getString(4));
				vo.setDescription(rs.getString(5));
				vo.setIntrodate(rs.getString(6));
				vo.setTitle(rs.getString(7));
				vo.setFollower(rs.getInt(8));
				vo.setPrice(rs.getDouble(9));
				vo.setThumbnail(rs.getString(10));
			}
		}catch(Exception e) {
			System.out.println("intro select error"+e.getMessage());
		}finally {
			dbClose();
		}
		return vo;
	}

	@Override
	public int introInsert(String userid) {
		int cnt = 0;
		try {
			dbConn();
			String sql = "insert into introtbl(introNo, userid, filename, interest, description, introdate,follower,price) values(introSq.nextVal, ?, 'Please attach the introvideo..', 'basic','(less than 500 letters)', sysdate,0,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("intro add content error"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	//메인에 쓰이는 추천 컨텐츠
	@Override
	public List<IntroVO> getRecommendContents(String interest) {
		//interest 자르기
		String interestArr[] = interest.split("/");
		for(int i =0; i<interestArr.length;i++) {
			System.out.println(interestArr[i]);
		}
		//
		List<IntroVO> list = new ArrayList<IntroVO>();
		try {
			dbConn();
			String sql ="select * from (";
			if(interest.equals("none")) {
				//로그인안한상태
				sql +="select * from introtbl order by follower desc";
				sql += ") where rownum<=6";
				pstmt = con.prepareStatement(sql);
				System.out.println("sql = "+sql);
			}else {
				if(interestArr.length==1){
					//관심사 1개
					sql +="select * from introtbl where  interest = ? order by follower desc";				
				}else if(interestArr.length==2){
					//관심사 2개
					sql +="select * from introtbl where  interest = ? or  interest = ? order by follower desc";
				}else if(interestArr.length==3){
					//관심사 3개
					sql +="select * from introtbl where  interest = ? or  interest = ? or interest= ? order by follower desc";
				}	
				sql += ") where rownum<=6";
				pstmt = con.prepareStatement(sql);
				
				for(int i=0 ; i<interestArr.length;i++) {
					System.out.println("배열길이 ="+interestArr.length);
					System.out.println(i);
					pstmt.setString(i+1, interestArr[i]);
				}
				System.out.println("sql = "+sql);
			}		
			
			sql += ") where rownum<=6";
			
			
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IntroVO vo = new IntroVO();
				vo.setIntroNo(rs.getInt("introno"));
				vo.setUserid(rs.getString("userid"));
				vo.setFilename(rs.getString("filename"));
				vo.setInterestStr(rs.getString("interest"));				
				vo.setDescription(rs.getString("description"));
				vo.setThumbnail(rs.getString("thumbnail"));
				vo.setIntrodate(rs.getString("introdate"));
				vo.setTitle(rs.getString("title"));
				vo.setFollower(rs.getInt("follower"));
				vo.setPrice(rs.getDouble("price"));
				list.add(vo);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get 6 recommendContents error");
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public String getInterest(String userid) {
		String interestStr ="";
		try {
			dbConn();
			String sql = "select interest from membertbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				interestStr = rs.getString("interest");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getInterest error");
		}finally{
			dbClose();
		}
		return interestStr;
	}

	@Override
	public List<IntroVO> getContent(String interest,String search) {
		List<IntroVO> list = new ArrayList<IntroVO>();
		String sql ="";
		try {
			dbConn();
			System.out.println("interest="+interest);
			//관심사,키워드 둘다 0
			if((interest.equals("")||interest.equals("all")) && search.equals("")) {
				sql = "select * from introtbl";
				pstmt = con.prepareStatement(sql);
			}
			//관심사만존재
			else if(search.equals("")&&( !interest.equals("") && !interest.equals("all"))) {
				sql = "select * from introtbl where interest=?";	
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, interest);
			}
			//키워드만존재
			else {
				sql = "select * from introtbl where title like '%"+search+"%' or description like '%"+search+"%'";
				pstmt = con.prepareStatement(sql);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IntroVO vo = new IntroVO();
				vo.setIntroNo(rs.getInt("introno"));
				vo.setUserid(rs.getString("userid"));
				vo.setFilename(rs.getString("filename"));
				vo.setInterestStr(rs.getString("interest"));				
				vo.setDescription(rs.getString("description"));
				vo.setThumbnail(rs.getString("thumbnail"));
				vo.setIntrodate(rs.getString("introdate"));
				vo.setTitle(rs.getString("title"));
				vo.setFollower(rs.getInt("follower"));
				vo.setPrice(rs.getDouble("price"));
				list.add(vo);				
			}
			System.out.println("list size in getConents method="+list.size());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getCONTENT error");
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public IntroVO getIntro(int introNo) {
		IntroVO vo = new IntroVO();
		try {
			dbConn();
			String sql = "select * from introtbl where introNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, introNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setIntroNo(rs.getInt("introno"));
				vo.setFilename(rs.getString("filename"));
				vo.setUserid(rs.getString("userid"));
				vo.setInterestStr(rs.getString("interest"));
				vo.setDescription(rs.getString("description"));
				vo.setIntrodate(rs.getString("introdate"));
				vo.setThumbnail(rs.getString("thumbnail"));
				vo.setTitle(rs.getString("title"));
				vo.setFollower(rs.getInt("follower"));
				vo.setPrice(rs.getDouble("price"));
				vo.setTotalStar(rs.getInt("totalStar"));
				System.out.println("get 하고있는 intro userid="+vo.getUserid());
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get intro error");
		}finally {
			dbClose();
		}
		return vo;
	}

	@Override
	public void totalStar(String contentid, int star) {
		try {
			dbConn();
			String sql = "update introtbl set totalstar=totalstar+? where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, star);
			pstmt.setString(2, contentid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("별점 평균값 구하기 에러"+e.getMessage());
		}finally {
			dbClose();
		}
		
	}

	@Override
	public IntroVO starRate(int introNo) {
		IntroVO vo = new IntroVO();
		try {
			dbConn();
			for(int i=1;i<=5;i++) {
				String sql = "select count(*) from (select * from replytbl where star="+i+" and introno=(select introno from introtbl where introno=?))";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, introNo);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(i==1) {vo.setOneStar(rs.getInt(1));}
					else if(i==2) {vo.setTwoStar(rs.getInt(1));}
					else if(i==3) {vo.setThreeStar(rs.getInt(1));}
					else if(i==4) {vo.setFourStar(rs.getInt(1));}
					else if(i==5) {vo.setFiveStar(rs.getInt(1));}
				}
			}			
		}catch(Exception e) {
			System.out.println("스타 퍼센트 에러"+e.getMessage());
		}finally {
			dbClose();
		}
		return vo;
	}
	public List<IntroVO> getAllIntro() {
		List<IntroVO> list = new ArrayList<IntroVO>();
		try {
			dbConn();
			String sql = "select* from introtbl";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IntroVO vo = new IntroVO();
				vo.setIntroNo(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setFilename(rs.getString(3));
				vo.setInterestStr(rs.getString(4));
				vo.setDescription(rs.getString(5));
				vo.setIntrodate(rs.getString(6));
				vo.setTitle(rs.getString(7));
				vo.setFollower(rs.getInt(8));
				vo.setPrice(rs.getDouble(9));
				vo.setThumbnail(rs.getString(10));
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("intro select error"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public int introDelete(int introNo) {
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from introtbl where introno=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, introNo);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delete intro error");
	}finally {
		dbClose();
	}
		return cnt;
	}

}
