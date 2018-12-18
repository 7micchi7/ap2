/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kougi05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex53 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //meiboデータベースへの接続とStatementの作成
            String driverUrl = "jdbc:derby://localhost:1527/meibo";
            Connection con
                    = DriverManager.getConnection(driverUrl, "db", "db");
            //Statement stmt = con.createStatement();

            //SQL文の作成（自分で記述）
            String sql = "insert into T_STUDENT_A "
					+ "(fullname, gakubu_id, grade) "
					+ "values (?,?,?) ";

			//PreparedStatementの作成
			PreparedStatement ps = con.prepareStatement(sql);

			//ファイルオープン
			BufferedReader br = new BufferedReader
				(new FileReader(new File("student.csv")));

			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				String[] word = line.split(",");

				ps.setString(1, word[0]);
				ps.setInt(2, Integer.parseInt(word[1]));
				ps.setInt(3, Integer.parseInt(word[2]));

				count += ps.executeUpdate();
			}

            System.out.println(count + "件のレコードを追加しました");

            //メモリの開放
			ps.close();
            con.close();

        } catch (IOException | NumberFormatException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}