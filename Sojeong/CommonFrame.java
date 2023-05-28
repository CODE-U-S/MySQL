package Sojeong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonFrame {
    public static Connection con;
    public static Statement stmt;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC", "root", "1234");
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getResulSet(String sql, Object... paramter) {
        try {
            var pstmt = con.prepareStatement(sql);

            for (int i = 0; i < paramter.length; i++) {
                pstmt.setObject(i + 1, paramter[i]);
            }

            //SELECT 전용
            return pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ResultSet updateSQL(String sql, Object... paramter) {
        try {
            var pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for (int i = 0; i < paramter.length; i++) {
                pstmt.setObject(i + 1, paramter[i]);
            }

            //INSER, UPDATE, DELETE 데이터 변경
            pstmt.executeUpdate();

            return pstmt.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
