import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MakeTable {
	public MakeTable() throws Exception {
        var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC", "root", "0178");
        var stmt = con.createStatement();
        
                stmt.execute("SET GLOBAL local_infile = 1");
                stmt.execute("DROP SCHEMA IF EXISTS `make_table`");
                stmt.execute("CREATE SCHEMA `make_table` DEFAULT CHARACTER SET utf8;"); 
        
                stmt.execute("CREATE TABLE `make_table`.`nation` ("
                        + "`n_no` INT NOT NULL AUTO_INCREMENT,"
                        + "c_no INT,"
                        + "code VARCHAR(3),"
                        + "n_name VARCHAR(20),"
                        + "x INT,"
                        + "y INT,"
                        + "PRIMARY KEY (`n_no`));");
                
                System.out.println("nation 생성 완료");

                stmt.execute("CREATE TABLE `make_table`.`division` ("
                        + "`d_no` INT NOT NULL AUTO_INCREMENT,"
                        + "d_name VARCHAR(50),"
                        + "PRIMARY KEY (`d_no`));");
        
                System.out.println("division 생성 완료");
        
                stmt.execute("CREATE TABLE `make_table`.`user` ("
                        + "`u_no` INT NOT NULL AUTO_INCREMENT,"
                        + "id VARCHAR(20),"
                        + "pw VARCHAR(20),"
                        + "name1 VARCHAR(20),"
                        + "name2 VARCHAR(20),"
                        + "birth DATE,"
                        + "mileage INT,"
                        + "PRIMARY KEY (`u_no`));");
        
                System.out.println("user 생성 완료");

                stmt.execute("CREATE TABLE `make_table`.`schedule` ("
                        + "`s_no` INT NOT NULL AUTO_INCREMENT,"
                        + "date DATE,"
                        + "depart INT,"
                        + "arrival INT,"
                        + "departTime TIME,"
                        + "timeTaken TIME,"
                        + "price INT,"
                        + "PRIMARY KEY (`s_no`));");
        
                System.out.println("schedule 생성 완료");

                stmt.execute("CREATE TABLE `make_table`.`continent` ("
                        + "`c_no` INT NOT NULL AUTO_INCREMENT,"
                        + "c_name VARCHAR(50),"
                        + "x INT,"
                        + "y INT,"
                        + "PRIMARY KEY (`c_no`));");        

                System.out.println("continent 생성 완료");
	}
	
	public static void main(String[] args) {
		try {
			new MakeTable();
			System.out.println("셋팅성공");
		} catch (Exception e) {
			System.out.println("셋팅실패");
			e.printStackTrace();
		}
	}
}
