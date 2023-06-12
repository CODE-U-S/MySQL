package Sojeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Frame0611 extends CommonFrame0611 {
	
	public Frame0611() throws IOException {

		System.out.println("student 정보 입력");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name = br.readLine();
		int grade = Integer.parseInt(br.readLine());
		int stu_num = Integer.parseInt(br.readLine());
		
		updateSQL("INSERT INTO `test0611`.`student` (name, grade, stu_num) VALUES (?, ?, ?)", name, grade, stu_num);
		
		br.close();
		
		var rs = getResult("SELECT * FROM `test0611`.`student`");
		
		try {
			while(rs.next()) {
				System.out.println("이름: " + rs.getString(2));
				System.out.println("학년: " + rs.getInt(3));
				System.out.println("학번: " + rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		new Frame0611();
	}


}
