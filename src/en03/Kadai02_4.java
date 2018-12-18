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
public class Kadai02_4 {
	public static void main(String[] args) {
		
		try {
			BufferedReader br =new BufferedReader(
				new FileReader(new File("bocchan_words.txt")));
			PrintWriter pw = new PrintWriter(
					new PrintWriter(new FileWriter(new File("bocchan_wordlist.txt"))));

			String line = "";

			while((line = br.readLine()) != null) {
				String[] Wline = line.split(" ");
				for(String s: Wline) {
					pw.append(s + "\n");
				}
			}

			br.close();
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
