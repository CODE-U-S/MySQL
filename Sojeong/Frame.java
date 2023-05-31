package Sojeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Frame extends CommonFrame {

	public Frame() throws IOException {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		// TODO: 값을 Create 할 거임
		updateSQL("INSERT INTO `jdbc`.`division` (d_name) VALUES (?)", str);
		// ?: 변동되는 값이 대입되는 부분 d_name에 str로 입력받은 값이 들어감
		/* INSERT INTO 테이블이름
		   열 컬럼 이름 ex) d_name (AUTO_INCREMENT를 하는 건 안됨. 즉, 넘버는 쓰면 안됨)
		 */
		System.out.println("nation 입력");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c_no = Integer.parseInt(br.readLine());
		String code = br.readLine();
		String n_name = br.readLine();
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		updateSQL("INSERT INTO `jdbc`.`nation` (c_no, code, n_name, x, y) VALUES (?, ?, ?, ?, ?)", c_no, code, n_name, x, y);
		
		System.out.println("user 입력");
		String id = br.readLine();
		String pw = br.readLine();
		String name1 = br.readLine();
		String name2 = br.readLine();
		int birth = Integer.parseInt(br.readLine());
		int mileage = Integer.parseInt(br.readLine());
		
		updateSQL("INSERT INTO `jdbc`.`user` (id, pw, name1, name2, birth, mileage) VALUES (?, ?, ?, ?, ?, ?)", id, pw, name1, name2, birth, mileage);
	
		System.out.println("schedule 입력");
		int date = Integer.parseInt(br.readLine());
		int depart = Integer.parseInt(br.readLine());
		int arrival = Integer.parseInt(br.readLine());
		int departTime = Integer.parseInt(br.readLine());
		int timeTaken = Integer.parseInt(br.readLine());
		int price = Integer.parseInt(br.readLine());
		
		updateSQL("INSERT INTO `jdbc`.`schedule` (date, depart, arrival, departTime, timeTaken, price) VALUES (?, ?, ?, ?, ?, ?)", date, depart, arrival, departTime, timeTaken, price);
		
		System.out.println("continent 입력");
		String c_name = br.readLine();
		int x2 = Integer.parseInt(br.readLine());
		int y2 = Integer.parseInt(br.readLine());
		updateSQL("INSERT INTO `jdbc`.`continent` (c_name, x, y) VALUES (?, ?, ?)", c_name, x2, y2);
		
		
		
		// TODO: 저장된 값을 불러올 거임
		var rs = getResulSet("SELECT * FROM `jdbc`.`division` WHERE d_name like 'hello'");
		var rs2 = getResulSet("SELECT * FROM `jdbc`.`nation`");
		// DB 문법이랑 같게 사용하면 됨
		
		try {
			while(rs.next()) {
				// 인덱스는 열 기준으로 1부터 (d_no는 1, d_name은 2)
				System.out.println(rs.getInt(1)); // d_no: Int값
				System.out.println(rs.getString(2)); // d_name: String값
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs2.next()) {
				System.out.println(rs2.getInt(1));
				System.out.println(rs2.getInt(2));
				System.out.println(rs2.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		new Frame();
	}

}
