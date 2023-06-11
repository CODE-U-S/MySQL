package Sojeong;

import java.sql.DriverManager;

public class Setting0611 {
	static void initDB() throws Exception {
		// 서버 연결
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("SET GLOBAL local_infile = 1");
		
		// 스키마, 테이블
		stmt.execute("DROP SCHEMA IF EXISTS `test0611`");
		
		stmt.execute("CREATE SCHEMA `test0611` DEFAULT CHARACTER SET utf8 ;");
		
		stmt.execute("CREATE TABLE `test0611`.`student` (\r\n"
				+ "  `no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `name` VARCHAR(20) NULL,\r\n"
				+ "  `grade` INT NULL,\r\n"
				+ "  `class_num` INT NULL,\r\n"
				+ "  PRIMARY KEY (`no`));\r\n"
				+ "");
		
		// user
		stmt.execute("DROP USER IF EXISTS 'user'@'127.0.0.1'");
		stmt.execute("CREATE USER 'user'@'127.0.0.1' IDENTIFIED BY '1234'");
		stmt.execute("GRANT SELECT, INSERT, UPDATE, DELETE ON `test0611` . `student` TO 'user'@'127.0.0.1'");
		
		System.out.println("user 생성 성공");
		
		// txt 파일
		stmt.execute("LOAD DATA LOCAL INFILE 'datafile/student.txt'"
				+ " INTO TABLE test0611.student"
				+ " IGNORE 1 LINES");
	}
	
	public static void main(String[] args) {
		try {
			initDB();
			System.out.println("세팅 성공!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

