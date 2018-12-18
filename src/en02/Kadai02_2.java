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
public class Kadai02_2 {
	public static void main(String[] args) {
		int maleCnt = 0;
		double maleWeight = 0;
		double maleAve = 0;
		int femaleCnt = 0;
		double femaleWeight = 0;
		double femaleAve = 0;

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
			if(cat.getSex().equals("オス")) {
				maleCnt++;
				maleWeight += cat.getWeight();
			}else {
				femaleCnt++;
				femaleWeight += cat.getWeight();
			}
		}
		maleAve = maleWeight/maleCnt;
		femaleAve = femaleWeight/femaleCnt;
		System.out.println("登録されている猫のうち、オスは" + maleCnt + "匹でメスは" + femaleCnt + "匹です。");
		System.out.printf("オスの平均体重は%.2fkgです。\n", maleWeight);
		System.out.printf("メスの平均体重は%.2fkgです。\n", femaleWeight);
	}
	
}
