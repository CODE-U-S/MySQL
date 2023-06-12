package setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class CommonFrame {
	static Connection con = null;
	static Statement stmt = null;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC", "user1", "1234");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet getResult(String sql, Object ...p) {
		try {
			var rs = con.prepareStatement(sql);
			for (int i = 0; i < p.length; i++) {
				rs.setObject(i + 1, p[i]);
			}
			
			return rs.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet updateSQL(String sql, Object ...p) {
		try {
			var rs = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < p.length; i++) {
				rs.setObject(i + 1, p[i]);
			}
			
			rs.executeUpdate();
			
			return rs.getGeneratedKeys();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
