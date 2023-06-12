package setting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Frame extends CommonFrame {
	public Frame() throws Exception {
		// crud
		
		// create
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int age = Integer.parseInt(br.readLine());
		updateSQL("INSERT INTO `jdbc`.`test` (name, age) VALUES (?, ?)", str, age);
		
		// read
		var rs = getResult("SELECT * FROM `jdbc`.`test`");
		while(rs.next()) {
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}
		
		// update
		updateSQL("UPDATE `jdbc`.`test` SET name = ? WHERE no = 1", "");
		
		// delete
		updateSQL("DELETE FROM `jdbc`.`test` WHERE no = 1");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		try {
			new Frame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
