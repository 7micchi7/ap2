/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C0117327
 */
public class Kadai02_1 {
	public static void main(String[] args) {
		List<Cat> Clist = new ArrayList<>();

		try {
			BufferedReader br =new BufferedReader(
				new FileReader(new File("en02_data.csv")));

			String line = "";
			
			while((line = br.readLine()) != null) {
				Cat cat = new Cat();
				String[] word = line.split(",");
				cat.setName(word[1]);
				cat.setKind(word[2]);
				cat.setSex(word[5]);
				cat.setWeight(Double.parseDouble(word[7]));

				Clist.add(cat);
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		for(Cat cat: Clist) {
			cat.printCat();
		}
	}
	
}
