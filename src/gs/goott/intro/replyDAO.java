package gs.goott.intro;

import java.util.ArrayList;
import java.util.List;

import gs.goott.util.DBConnection;

public class replyDAO extends DBConnection implements ReplyInterface {

	@Override
	public int writeReply(String commenter, String commentContent, Double star,int introNo) {
		int cnt =0;
		try {
			dbConn();
			String sql = "insert into replytbl values(?,replysq.nextval,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,introNo);
			pstmt.setString(2, commenter);
			pstmt.setString(3,commentContent);
			pstmt.setDouble(4, star);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("write reply error");
		}finally {
			dbClose();
		}		
		return cnt;
	}

	@Override
	public List<replyVO> getReply(int introNo) {
		List<replyVO> list = new ArrayList<replyVO>();
		try {
			dbConn();
			String sql ="select * from replytbl where introno =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, introNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				replyVO vo = new replyVO();
				vo.setIntroNo(introNo);
				vo.setCommentNo(rs.getInt("commentno"));
				vo.setCommenter(rs.getString("commenter"));
				vo.setCommentContent(rs.getString("commentcontent"));
				vo.setCommentDate(rs.getString("commentdate"));
				vo.setStar(rs.getDouble("star"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("get reply error");
		}finally {
			dbClose();
		}
		return list;
	}
	
}
