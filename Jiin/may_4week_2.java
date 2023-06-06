package homework;

import java.sql.SQLException;
import java.util.Scanner;

public class may_4week_2 extends CommonFrame{
	public may_4week_2() {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		update("INSERT INTO `mysqlMay4`.`division` (d_name) VALUES(?)", data);
		var res = getResult("SELECT * FROM `mysqlMay4`.`division`");
		try {
			while(res.next()) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new may_4week_2();
	}
}
