/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en00;

import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author C0117327
 */
public class Q05 {
	public static void main(String[] args) {
		Calendar cl = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日(EE) kk時mm分ss秒");
		System.out.println(sdf.format(cl.getTime()));
	
		
	}
}
