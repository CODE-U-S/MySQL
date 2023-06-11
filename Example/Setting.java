package MySQL.예제코드;

import java.sql.DriverManager;

public class Setting {
    public Setting() throws Exception {
        // localhost : 127.0.0.1 -> 연결
        var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
        var stmt = con.createStatement();

        stmt.execute("SET GLOBAL local_infile=1");

        // 스키마가 있을 때 : IF EXISTS
        // 삭제 시킬 거다 : DROP
        // 무엇을 ? : `스키마 이름`

        // 아예 스키마를 없앴다가 생성하면 값도 초기화됨
        // `스키마 이름` 있을 경우 삭제 시킬거다
        stmt.execute("  DROP SCHEMA IF EXISTS `jdbc`");
        // jdbc라는 스키마를 새로 만드는 거고...
        stmt.execute("CREATE SCHEMA `jdbc` DEFAULT CHARACTER SET utf8 ;");

        // 테이블 생성
        stmt.execute("CREATE TABLE `jdbc`.`division` (\r\n"
                + "  `d_no` INT NOT NULL AUTO_INCREMENT,\r\n"
                + "  `d_name` VARCHAR(50) NULL,\r\n"
                + "  PRIMARY KEY (`d_no`));\r\n"
                + "");

        System.out.println("division Table 생성");

        // 테이블 생성
        stmt.execute("CREATE TABLE `jdbc`.`test` ("
                + "t_no INT AUTO_INCREMENT,"
                + "t_name VARCHAR(50),"
                + "PRIMARY KEY (`t_no`));");

        System.out.println("test Table 생성");

        // user 생성
        stmt.execute("DROP USER IF EXISTS 'user'@'127.0.0.1'");
        stmt.execute("CREATE USER 'user'@'127.0.0.1' IDENTIFIED BY '1234'");
        stmt.execute("GRANT SELECT, INSERT, UPDATE, DELETE ON `jdbc`.* TO 'user'@'127.0.0.1'");
        stmt.execute("USE `jdbc`");

        // txt파일 데이터로 넣기
        stmt.execut("LOAD DATA LOCAL INFILE 'datafiles/test.txt'
                + " INTO TABLE test"
                + " IGNORE 1 LINES");
    }

    public static void main(String[] args) {
        try {
            new Setting();
            System.out.println("셋팅성공");
        } catch (Exception e) {
            System.out.println("셋팅실패");
            e.printStackTrace();
        }
    }
}