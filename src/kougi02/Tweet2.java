/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kougi02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author C0117327
 */
public class Tweet2 {

	private int tweetNo;
	private String twitterId;
	private String name;
	private Date tweetTime;
	private String text;

	public void setNo(int tn) {
		this.tweetNo = tn;
	}

	public void setTID(String tid) {
		this.twitterId = tid;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setTime(String tm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
			Date date = sdf.parse(tm);
			this.tweetTime = date;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Date getTime() {
		return tweetTime;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public void printTweet() {
		System.out.println(tweetNo + ":" 
			+ twitterId + "(" + name + ")\n"
			+ tweetTime + "\n" + text);
	}
}
