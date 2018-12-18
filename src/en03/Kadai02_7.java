/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author C0117327
 */
public class Kadai02_7 {
	public static void main(String[] args) {
		String keyword = "学校";
		String line;
		String firstW = "";
		String secondW = "";
		
		try {
			BufferedReader br =new BufferedReader(
				new FileReader(new File("bocchan_wordlist.txt")));
			PrintWriter pw = new PrintWriter(
					new PrintWriter(new FileWriter(new File("bocchan_3wordlist.txt"))));

			while((line = br.readLine()) != null) {
				if(secondW.equals(keyword)) {
					pw.append(firstW + "\t" + secondW + "\t" + line + "\n");
				}
				firstW = secondW;
				secondW = line;
			}

			br.close();
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
