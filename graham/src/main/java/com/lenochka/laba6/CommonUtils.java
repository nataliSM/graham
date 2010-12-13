package com.lenochka.laba6;

/**
 * @author Lenochka
 *
 */
public class CommonUtils {
	
	public static void swap(Object[] data, int a, int b){
		Object tmp = data[a];
		data[a] = data[b];
		data[b] = tmp;
	}
	
}
