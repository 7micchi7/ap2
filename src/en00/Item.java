/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package en00;

/**
 *
 * @author C0117327
 */
public class Item {
	private static String name;
	private static int value;
	public Item(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public int getValue() {
		return this.value;
	}

	public void setName(String name	) {
		this.name = name;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
