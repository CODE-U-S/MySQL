package MySQL.Example;

import java.sql.SQLException;
import java.util.Scanner;

public class Frame extends CommonFrame {
    public Frame() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        // TODO : 값을 Create 할거임
        updateSQL("INSERT INTO `jdbc`.`division` (d_name) VALUES (?)", str);

        // TODO : 값을 불러올거고
        var rs = getResulSet("SELECT * FROM `jdbc`.`division` WHERE d_name like 'hello'");
        try {
            while (rs.next()) {
                // get불러올 때 index값이 1부터 시작됨
                System.out.println(rs.getInt(1)); // d_no : Int값
                System.out.println(rs.getString(2)); // d_name : String값
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sc.close();
    }

    public static void main(String[] args) {
        new Frame();
    }
}
