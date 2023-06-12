package setting;

import java.sql.DriverManager;

// Setting 파일은 데이터값을 나중에 crud 으로 고쳐해줌 -> 초기값으로 데이터를 초기화하고 싶어
public class Setting {
	public Setting() throws Exception {
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		// 클라이언트, 서버에 설정을 해주는 거임 -> 파일을 불러오는거랑 파일가지고 mysql에 접근할 수 있는거 이걸 허용해줌
		stmt.execute("SET GLOBAL local_infile = 1");
		// allowLoadLocalInfile = true, SET GLOBAL local_infile = 1 은 세트로 허용해줘야함
		
		// IF EXISTS : 만약에 스키마가 존재한다면
		// drop을 시킬거다
		// 무슨 스키마를 : `스키마이름`
		stmt.execute("DROP SCHEMA IF EXISTS `jdbc`");
		
		// 스키마 생성
		stmt.execute("CREATE SCHEMA `jdbc` DEFAULT CHARACTER SET utf8 ;");
		
		
		// 테이블
		stmt.execute("CREATE TABLE `jdbc`.`test` (\r\n"
				+ "  `no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `name` VARCHAR(50) NULL,\r\n"
				+ "  `age` INT NULL,\r\n"
				+ "  PRIMARY KEY (`no`));\r\n"
				+ "");
		
		System.out.println("test Table 완성");
		
		// user 지움
		stmt.execute("DROP USER IF EXISTS 'user1'@'127.0.0.1'");
		
		// user 생성
		stmt.execute("CREATE USER 'user1'@'127.0.0.1' IDENTIFIED BY '1234'");
		
		// user 권한 필요
		stmt.execute("GRANT INSERT, SELECT, UPDATE, DELETE ON `jdbc`.* TO 'user1'@'127.0.0.1'");
		
		System.out.println("user1 생성");
		
		stmt.execute("USE `jdbc`");
		
		// LOAD DATA LOCAL INFILE -> file을 data로 넘기고 싶어
		// 무슨 file? -> 'test.txt'
		// 어디 table에 보낼건데 ? -> INTO TABLE test
		// IGNORE 1 LINES -> 첫번째 줄을 무시할거야!
		stmt.execute("LOAD DATA LOCAL INFILE 'test.txt'"
				+ " INTO TABLE test"
				+ " IGNORE 1 LINES");
		
		System.out.println("test txt파일을 업로드 성공");
				
				
	}
	
	
	public static void main(String[] args) {
		try {
			new Setting();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
