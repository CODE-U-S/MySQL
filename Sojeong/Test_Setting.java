package Sojeong;

import java.sql.DriverManager;

public class Test_Setting {
	public Test_Setting() throws Exception {
		// localhost: 127.0.0.1 -> 연결
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC", "root", "1234");
		var stmt = con.createStatement();
		
		stmt.execute("SET GLOBAL local_infile = 1");
		
		// 스키마가 있을 떄: IF EXISTS
		// 삭제시킬 것이다: DROP
		// 무엇을?: `스키마 이름`
		
		// `스키마 이름` 있을 경우 삭제시킬 것이다 -> 초기화 시킴 (아예 스키마를 없앴다가 생성하면 값도 초기화)
		stmt.execute("DROP SCHEMA IF EXISTS `jdbc`");
		// jdbc라는 스키마를 새로 만드는 것
		stmt.execute("CREATE SCHEMA `jdbc` DEFAULT CHARACTER SET utf8 ;");
		
		stmt.execute("CREATE TABLE `jdbc`.`division` (\r\n"
				+ "  `d_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `d_name` VARCHAR(50) NULL,\r\n"
				+ "  PRIMARY KEY (`d_no`));\r\n"
				+ "");
		System.out.println("division 테이블 생성");
		
		
		stmt.execute("CREATE TABLE `jdbc`.`nation` (\r\n"
				+ "  `n_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `code` VARCHAR(3) NULL,\r\n"
				+ "  `n_name` VARCHAR(20) NULL,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  PRIMARY KEY (`n_no`));\r\n"
				+ "");
		System.out.println("nation 테이블 생성");
		
		stmt.execute("CREATE TABLE `jdbc`.`user` (\r\n"
				+ "  `u_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `id` VARCHAR(20) NULL,\r\n"
				+ "  `pw` VARCHAR(20) NULL,\r\n"
				+ "  `name1` VARCHAR(20) NULL,\r\n"
				+ "  `name2` VARCHAR(20) NULL,\r\n"
				+ "  `birth` DATE NULL,\r\n"
				+ "  `mileage` INT NULL,\r\n"
				+ "  PRIMARY KEY (`u_no`));\r\n"
				+ "");
		System.out.println("user 테이블 생성");
		
		stmt.execute("CREATE TABLE `jdbc`.`schedule` (\r\n"
				+ "  `s_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `date` DATE NULL,\r\n"
				+ "  `depart` INT NULL,\r\n"
				+ "  `arrival` INT NULL,\r\n"
				+ "  `departTime` TIME NULL,\r\n"
				+ "  `timeTaken` TIME NULL,\r\n"
				+ "  `price` INT NULL,\r\n"
				+ "  PRIMARY KEY (`s_no`))\r\n"
				+ "");
		System.out.println("schedule 테이블 생성");
		
		stmt.execute("CREATE TABLE `jdbc`.`continent` (\r\n"
				+ "  `c_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_name` VARCHAR(50) NULL,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  PRIMARY KEY (`c_no`))\r\n"
				+ "");
		System.out.println("continent 테이블 생성");
		
		stmt.execute("CREATE TABLE jdbc.test ("
                + "t_no INT AUTO_INCREMENT,"
                + "t_name VARCHAR(50),"
                + "PRIMARY KEY (t_no));");

        System.out.println("test Table 생성");
	}
	
	public static void main(String[] args) {
		try {
			new Test_Setting();
			System.out.println("세팅 성공");
		} catch (Exception e) {
			System.out.println("세팅 실패");
			e.printStackTrace();
		}

	}

}
