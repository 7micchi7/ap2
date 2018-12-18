package kougi02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author C0117327
 */
public class Ex24 {
	public static void main(String[] args) {
		List<Tweet2> tlist =new ArrayList<>();

		try {
			BufferedReader br =new BufferedReader(
				new FileReader(new File("tweet2.csv")));
			String line = "";

			while((line = br.readLine()) != null) {
				Tweet2 tweet = new Tweet2();
				String[] word = line.split(",");
				tweet.setNo(Integer.parseInt(word[0]));
				tweet.setTID(word[1]);
				tweet.setName(word[2]);
				tweet.setTime(word[3]);
				tweet.setText(word[4]);

				tlist.add(tweet);
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Tweet2 tweet2: tlist) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -10);

			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(tweet2.getTime());

			boolean after10 = cal2.after(cal);

			if(after10) {
				tweet2.printTweet();
			}
		}

	}
}
