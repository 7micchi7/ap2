/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author C0117327
 */
public class Kadai05_2 {
	public static void main(String[] args) {
         try {
            //meiboデータベースへの接続とStatementの作成
            String driverUrl = "jdbc:derby://localhost:1527/twitter";
            Connection con
                    = DriverManager.getConnection(driverUrl, "db", "db");

            //SQL文の作成（自分で記述）
            String sql = "insert into T_TWEET "
					+ "(id, text, retweet) "
					+ "values (?,?,?) ";

			//PreparedStatementの作成
			PreparedStatement ps = con.prepareStatement(sql);

			//SQL文に値を設定
			ps.setString(1, "abc"); //1番目の「？」
			ps.setString(2, "できた！");
			ps.setInt(3, 5);

            //SQL文の実行（自分で記述）
            //int count = stmt.executeUpdate(sql);
			int count = ps.executeUpdate();
            System.out.println(count + "件のレコードを追加しました");

            //メモリの開放
			ps.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
