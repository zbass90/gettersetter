package gs.goott.content;

import java.util.ArrayList;
import java.util.List;

import gs.goott.util.DBConnection;

public class ContentDAO extends DBConnection implements ContentInterface {

	@Override
	public int contentWrite(ContentVO vo) {
		int cnt = 0;			
		try {
			dbConn();
			String sql = "insert into contenttbl values(contentSq.nextVal, ?, ?, ?, ?, 0, sysdate, ?, ?, ?)"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getFilename());
			pstmt.setString(4, vo.getDescription());
			pstmt.setString(5, vo.getInterest());
			pstmt.setString(6, vo.getThumbnail());
			pstmt.setFloat(7, vo.getVideoLength());
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("contentwrite error"+e.getMessage());
		}finally {
			dbClose();
		}
		return cnt; 
	}

	@Override
	public List<ContentVO> getContentList(String userid) {
		List<ContentVO> list = new ArrayList<ContentVO>();
		try {
			dbConn();
			String sql = "select contentno, userid, title, interest, videolength from contenttbl where userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ContentVO vo = new ContentVO();
				vo.setContentNo(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setInterest(rs.getString(4));
				vo.setVideoLength(rs.getFloat(5));
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("컨텐츠 목록 불러오기 에러"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public ContentVO getContent(String userid, int contentNo) {
		ContentVO vo = new ContentVO();
		try {
			dbConn();
			String sql="select contentNo, userid, title, filename, description, views, to_char(uploaddate, 'DD Mon YYYY','NLS_DATE_LANGUAGE=ENGLISH'), interest, thumbnail from contenttbl where userid=? and contentNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, contentNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setContentNo(rs.getInt(1));
				vo.setUserid(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setFilename(rs.getString(4));
				vo.setDescription(rs.getString(5));
				vo.setViews(rs.getInt(6));
				vo.setUploadDate(rs.getString(7));
				vo.setInterest(rs.getString(8));
				vo.setThumbnail(rs.getString(9));
			}
		}catch(Exception e) {
			System.out.println("컨텐츠 1개 출력 에러"+e.getMessage());
		}finally {
			dbClose();
		}
		return vo;
	}

	@Override
	public List<ContentVO> getInterestList(String userid, String interest, int contentNo) {
		List<ContentVO> list = new ArrayList<ContentVO>();
		try {
			dbConn();
			String sql = "select thumbnail, title, userid, views, contentNo, interest from contenttbl where userid=? and interest=? and contentNo!=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, interest);
			pstmt.setInt(3, contentNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ContentVO vo = new ContentVO();
				vo.setThumbnail(rs.getString(1));
				vo.setTitle(rs.getString(2));
				vo.setUserid(rs.getString(3));
				vo.setViews(rs.getInt(4));
				vo.setContentNo(rs.getInt(5));
				vo.setInterest(rs.getString(6));
				list.add(vo);
			}
		}catch(Exception e) {
			System.out.println("컨텐츠 관심 분야 목록 출력 에러!"+e.getMessage());
		}finally {
			dbClose();
		}
		return list;
	}

	@Override
	public void viewCount(int contentNo) {
		try {
			dbConn();
			String sql = "update contenttbl set views=views+1 where contentNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, contentNo);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("컨텐츠 조회수 증가 에러"+e.getMessage());
		}finally {
			dbClose();
		}
	}
	
	
}
