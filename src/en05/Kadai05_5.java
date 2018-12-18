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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class Kadai05_5 {

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
            String sql = "select * from T_TWEET "
					+ "where tweetdate > ? ";

			//PreparedStatementの作成
			PreparedStatement ps = con.prepareStatement(sql);

			Calendar calendar = Calendar.getInstance();
			System.out.println("現在の日時:" + calendar.getTime());
			calendar.add(Calendar.DAY_OF_MONTH, -10);
			System.out.println("１０日前の日時:" + calendar.getTime());
			Timestamp tm = new Timestamp(calendar.getTimeInMillis());

			ps.setTimestamp(1, tm);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				System.out.print(rs.getString(1) + ":");
				System.out.print(rs.getString(2) + ":");
				System.out.print(rs.getString(3) + ":");
				System.out.print(rs.getString(4) + ":");
				System.out.print(rs.getString(5) + "\n");
			}
			System.out.println();

            //メモリの開放
			ps.close();
            con.close();

        } catch (NumberFormatException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}