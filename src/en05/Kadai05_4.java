/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en05;

import kougi05.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Kadai05_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //meiboデータベースへの接続とStatementの作成
            String driverUrl = "jdbc:derby://localhost:1527/twitter";
            Connection con
                    = DriverManager.getConnection(driverUrl, "db", "db");
            //Statement stmt = con.createStatement();

            //SQL文の作成（自分で記述）
            String sql = "insert into T_TWEET "
					+ "(id, text, retweet, tweetdate) "
					+ "values (?,?,?,?) ";

			//PreparedStatementの作成
			PreparedStatement ps = con.prepareStatement(sql);

			//ファイルオープン
			BufferedReader br = new BufferedReader
				(new FileReader(new File("tweet54.csv")));

			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				String[] word = line.split(",");
				Timestamp timestamp = Timestamp.valueOf(word[3]);

				ps.setString(1, word[0]);
				ps.setString(2, word[1]);
				ps.setInt(3, Integer.parseInt(word[2]));
				ps.setTimestamp(4, timestamp);

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