/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C0117327
 */
public class kadai01_2 {
	public static void main(String[] args) {
		int count = 0;
		int sum = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("out11.txt")));
			
			String line;
			List<String> list = new ArrayList<>();
			
			while((line = br.readLine()) != null){
				list.add(line);
			}
			

			PrintWriter pw = new PrintWriter(new PrintWriter(new FileWriter(new File("out12.txt"))));
			pw.append("消費リスト:");
			for(int i = 0; i < list.size(); i+=2){
				pw.append(list.get(i)+"/");
			}
			pw.append("\n");
			pw.append("合計:");
			for(int i = 1; i < list.size(); i+=2){
				sum += Integer.parseInt(list.get(i));
			}
			pw.append(String.valueOf(sum));

			br.close();
			pw.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
