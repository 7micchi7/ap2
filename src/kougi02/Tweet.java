/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kougi02;

/**
 *
 * @author C0117327
 */
public class Tweet {

	private int tweetNo;
	private String twitterId;
	private String name;
	private String tweetTime;
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

	public void setTime(String tweetTime) {
		this.tweetTime = tweetTime;
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
