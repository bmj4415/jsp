package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public void getConnection() { // Connection->void : 위쪽에 객체로 사용하기 때문에 변경하고 아래 리턴값도 제거
		String url = "jdbc:oracle:thin:@localhost:1521:Xe";//@로컬호스트/포트/
		String user = "jsp";
		String passwd = "jsp";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconn() {
			try {
				if(rs != null) {
				rs.close();
				}
				if(psmt != null) {
					psmt.close();
				} if(conn != null) {
					psmt.close();
				}	
				} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
}//
