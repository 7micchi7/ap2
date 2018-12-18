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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author C0117327
 */
public class Kadai02_6 {
	public static void main(String[] args) {
		String line;
		Map<String, Integer> countMap = new HashMap<>();
		try {
			BufferedReader br =new BufferedReader(
				new FileReader(new File("bocchan_wordlist.txt")));
			PrintWriter pw = new PrintWriter(
					new PrintWriter(new FileWriter(new File("bocchan_count.txt"))));

			while((line = br.readLine()) != null) {
				if(countMap.containsKey(line)){
					countMap.put(line, countMap.get(line)+1);
				} else {
					countMap.put(line, 1);
				}
			}

			for (String key: countMap.keySet()) {
				pw.append(key + ", " + countMap.get(key) + "\n");
			}

			br.close();
			pw.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
