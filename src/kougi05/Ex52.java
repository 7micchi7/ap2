/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kougi05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex52 {

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

			//SQL文に値を設定
			ps.setString(1, "星野源"); //1番目の「？」
			ps.setInt(2, 2);
			ps.setInt(3, 3);

            //SQL文の実行（自分で記述）
            //int count = stmt.executeUpdate(sql);
			int count = ps.executeUpdate();
            System.out.println(count + "件のレコードを追加しました");

            //メモリの開放
            //stmt.close();
			ps.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}