package day0611;

import java.sql.DriverManager;

public class Setting {
	static void initDB() throws Exception {
		
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		stmt.execute("SET GLOBAL local_infile = 1");
        stmt.execute("DROP SCHEMA IF EXISTS homework_coders");
        stmt.execute("CREATE SCHEMA homework_coders DEFAULT CHARACTER SET utf8;");
        
		stmt.execute("DROP USER IF EXISTS 'user_jiin'@'127.0.0.1'");
		stmt.execute("CREATE USER 'user_jiin'@'127.0.0.1' IDENTIFIED BY '1234'");
		stmt.execute("GRANT SELECT, INSERT, UPDATE, DELETE ON `jiin`.`new_jiin` TO `user_jiin`@127.0.0.1");
		System.out.println("사용자 생성 완료");
		
		stmt.execute("LOAD DATA LOCAL INFILE 'jajudooum.txt'"
				+ " INTO TABLE jiin.new_jiin");
		System.out.println("txt파일 넣음");
	}
	public static void main(String[] args) {
		try {
			initDB();
			System.out.println("셋팅 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("셋팅 실패");
		}
	}

}
//CREATE SCHEMA `jiin` DEFAULT CHARACTER SET utf8 ;
