package Sojeong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CommonFrame0611 {
	static Connection con;
	static Statement stmt;
	
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC", "user", "1234");
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// R
	public static ResultSet getResult(String sql, Object... p) {
		try {
			var pstmt = con.prepareStatement(sql);
			
			for(int i = 0; i < p.length; i++) {
				pstmt.setObject(i + 1, p[i]);
			}
			
			return pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	// U, D
	public static ResultSet updateSQL(String sql, Object... p) { // void형으로 바꾸고 return 없애도 가능
		try {
			var pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			
			for(int i = 0; i < p.length; i++) {
				pstmt.setObject(i + 1, p[i]);
			}
			
			pstmt.executeUpdate();
			
			return pstmt.getGeneratedKeys();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
