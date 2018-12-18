/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en00;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C0117327
 */
public class Q04 {
	public static void main(String[] args) {
		List<String> slist = new ArrayList<String>();
		slist.add("Apple");
		slist.add("Orange");
		slist.remove(1);
		slist.add(1, "banana");

		for(String a : slist) {
			System.out.println(a);
		}
	}
	
}
