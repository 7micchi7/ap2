/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author C0117327
 */
public class Kadai04_1 {
	public static void main(String[] args) {
		try {
			//meiboデータベースへの接続
			String driverUrl = "jdbc:derby://localhost:1527/meibo";

			//コネクションの確立
			Connection con
					= DriverManager.getConnection(driverUrl, "db", "db");

			//ステートメントの作成
			Statement stmt = con.createStatement();

			//実行するSQL文を記述
			String sql = "select * from T_STUDENT";

			//SQLを実行してResultSetの形式で結果を取得
			ResultSet rs = stmt.executeQuery(sql);

			//取得したレコードを一つずつ処理
			System.out.println("STUDENT_ID   FULLNAME   GAKUBU_ID  GRADE SCORE");
			while (rs.next()) {
				System.out.printf("%10d %8s %9d %5d %5d\n", rs.getInt("student_id"), rs.getString("fullname"), rs.getInt("gakubu_id"), rs.getInt("grade"), rs.getInt("score"));
			}
			//メモリの開放
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
