package code_us;

import java.sql.SQLException;
import java.util.Scanner;

public class Frame extends CommonFrame{
	public Frame() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		// TODO : 값을 create 하자.
		updateSQL("INSERT INTO `jdbc`.`division` (d_name) VALUES(?)", str);//절대값은 무조건 안좋으니까 ?를 사용하여 printf처럼 사용하자.
		//TODO : 값 불러오기
		var rs = getResulSet("SELECT * FROM `jdbc`.`division`"); //WHERE d_name like 'dlwlstjs'
		try {
			while(rs.next()) {
				//get불러올 때 index값이 1부터 시작
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Frame();
	}

}
