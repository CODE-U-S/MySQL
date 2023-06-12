package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Setting {
	Setting() throws SQLException{
		 var conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "admin_java");
	     var stmt = conn.createStatement();
	     
	     stmt.execute("SET GLOBAL local_infile = 1");
	     stmt.execute("DROP SCHEMA IF EXISTS `homework_coders`");
	     stmt.execute("CREATE SCHEMA `homework_coders` DEFAULT CHARACTER SET utf8;");
	     System.out.println("연결완료");
	     
	     stmt.execute("CREATE TABLE `homework_coders`.`just_table`("
					+ "`just_no` INT NOT NULL AUTO_INCREMENT,"
					+ "`just_note` VARCHAR(50) NULL,"
					+ "`just_num` INT NULL,"
					+ "PRIMARY KEY (`just_no`));");
	     System.out.println("테이블 생성 완료");
	     
	     stmt.execute("DROP USER IF EXISTS 'just_user'@'127.0.0.1'");
	     stmt.execute("CREATE USER 'just_user'@'127.0.0.1' IDENTIFIED BY '1234'");
	     stmt.execute("GRANT SELECT, INSERT, UPDATE, DELETE ON `homework_coders`.`just_table` TO 'just_user'@'127.0.0.1'");
	     System.out.println("유저 세팅 완료");
	     
	     stmt.execute("LOAD DATA LOCAL INFILE 'src/homework/just_file.txt'"
	     		+ " INTO TABLE homework_coders.just_table");
	}
	
	
	public static void main(String[] args) {
		try {
			new Setting();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
