package may_2023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class may_4week {
    public may_4week() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC", "root", "1234321");
        Statement stmt = con.createStatement();

        stmt.execute("SET GLOBAL local_infile = 1");
        stmt.execute("DROP SCHEMA IF EXISTS `mysqlMay4`");
        stmt.execute("CREATE SCHEMA `mysqlMay4` DEFAULT CHARACTER SET utf8;");

        stmt.execute("CREATE TABLE `mysqlMay4`.`nation` (" 
                + "`n_no` INT NOT NULL AUTO_INCREMENT,"
                + "c_no INT,"
                + "code VARCHAR(3),"
                + "n_name VARCHAR(20),"
                + "x INT,"
                + "y INT,"
                //+ "FOREIGN KEY(c_no) REFERENCES DEPARTMENT(c_no),"
                + "PRIMARY KEY (`n_no`));");
        System.out.println("nation 테이블 완료");
        
        stmt.execute("CREATE TABLE `mysqlMay4`.`division` (" 
                + "`d_no` INT NOT NULL AUTO_INCREMENT,"
                + "d_name VARCHAR(50),"
                + "PRIMARY KEY (`d_no`));");
        System.out.println("division 테이블 완료");
        
        stmt.execute("CREATE TABLE `mysqlMay4`.`continent` (" 
                + "`c_no` INT NOT NULL AUTO_INCREMENT,"
                + "c_name VARCHAR(50),"
                + "code VARCHAR(3),"
                + "x INT,"
                + "y INT,"
                + "PRIMARY KEY (`c_no`));");
        System.out.println("continent 테이블 완료");
        
        stmt.execute("CREATE TABLE `mysqlMay4`.`schedule` (" 
                + "`s_no` INT NOT NULL AUTO_INCREMENT,"
                + "data DATE,"
                + "depart INT,"
                + "arrival INT,"
                + "departTime TIME,"
                + "timeTaken TIME,"
                + "price INT,"
                + "PRIMARY KEY (`s_no`));");
        System.out.println("schedule 테이블 완료");
        
        stmt.execute("CREATE TABLE `mysqlMay4`.`user` (" 
                + "`u_no` INT NOT NULL AUTO_INCREMENT,"
                + "id VARCHAR(20),"
                + "pw VARCHAR(20),"
                + "name1 VARCHAR(20),"
                + "name2 VARCHAR(20),"
                + "brith DATE,"
                + "mileage INT,"
                + "PRIMARY KEY (`u_no`));");
        System.out.println("user 테이블 완료");

    }

    public static void main(String[] args) {
        try {
            new may_4week();
            System.out.println("-------------------");
            System.out.println("모든 테이블 생성 완료!");
        } catch (SQLException e) {
        	System.out.println("테이블 생성 오류 발생!");
            e.printStackTrace();
        }
    }
}
