package code_us;

import java.sql.DriverManager;

public class nation {
	public nation() throws Exception{
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC", "root", "1234");
		var stmt = con.createStatement();
	
		stmt.execute("SET GLOBAL local_infile=1");
		stmt.execute("DROP SCHEMA IF EXISTS `nation`");
		stmt.execute("CREATE SCHEMA `nation` DEFAULT CHARACTER SET utf8 ;");
		
		stmt.execute("CREATE TABLE `nation`.`nation` (\r\n"
				+ "  `n_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_no` INT NULL,\r\n"
				+ "  `code` VARCHAR(3) NULL,\r\n"
				+ "  `n_name` VARCHAR(20) NULL,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  PRIMARY KEY (`n_no`));");
		System.out.println("nation");
		
		stmt.execute("CREATE TABLE `nation`.`division` (\r\n"
				+ "  `d_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `d_name` VARCHAR(50) NULL,\r\n"
				+ "  PRIMARY KEY (`d_no`));");
		System.out.println("division");
		
		stmt.execute("CREATE TABLE `nation`.`user` (\r\n"
				+ "  `u_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `id` VARCHAR(20) NULL,\r\n"
				+ "  `pw` VARCHAR(20) NULL,\r\n"
				+ "  `name1` VARCHAR(20) NULL,\r\n"
				+ "  `name2` VARCHAR(20) NULL,\r\n"
				+ "  `birth` DATE NULL,\r\n"
				+ "  `mileage` INT NULL,\r\n"
				+ "  PRIMARY KEY (`u_no`));");
		System.out.println("user");
		
		stmt.execute("CREATE TABLE `nation`.`schedule` (\r\n"
				+ "  `s_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `date` DATE NULL,\r\n"
				+ "  `depart` INT NULL,\r\n"
				+ "  `arrival` INT NULL,\r\n"
				+ "  `departTime` TIME NULL,\r\n"
				+ "  `timeTaken` TIME NULL,\r\n"
				+ "  `price` INT NULL,\r\n"
				+ "  PRIMARY KEY (`s_no`));");
		System.out.println("schedule");
		
		stmt.execute("CREATE TABLE `nation`.`continent` (\r\n"
				+ "  `c_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `c_name` VARCHAR(50) NULL,\r\n"
				+ "  `x` INT NULL,\r\n"
				+ "  `y` INT NULL,\r\n"
				+ "  PRIMARY KEY (`c_no`));");
		System.out.println("continent");
	}
	public static void main(String[] args) {
		try {
			new nation();
			System.out.println("부팅성공");
		}catch(Exception e) {
			System.out.println("부팅실패");
			e.printStackTrace();
		}
	}

}
