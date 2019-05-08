package gs.goott.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	protected PreparedStatement pstmt =null; //상속받아 쓸 수 있도록 protected로 제한
	protected ResultSet rs=null;
	protected Connection con=null;

	//DB연결 메소드
	public void dbConn() {
		try {
			Context ctx1 = new InitialContext();
			Context ctx2 = (Context)ctx1.lookup("java:comp/env");
			DataSource ds = (DataSource)ctx2.lookup("jdbc/myoracle");
			con = ds.getConnection();
		}catch(Exception e) {
			System.out.println("DB연결에러..."+e.getMessage());
		}
	}

	//DB연결해제 메소드
	public void dbClose() {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			System.out.println("DB닫기에러..."+e.getMessage());
		}
	}
	

}
