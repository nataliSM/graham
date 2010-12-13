/**
 * 
 */
package com.lenochka.laba6.benchmark;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.lenochka.laba6.convex.Point;

/**
 * @author Lenochka
 *
 */
public class SourceGeneratorInsideTest {
	
	public static final Float Q = 200F;
	public static final Float W = 500F;
	public static final int N = 50000;

	
	@Test
	public void generate(){
		SourceGenerator sg = new SourceGeneratorOnBorder(100);
		Point[] source = sg.genarete(Q, W, N);		
		for (Point point : source) {
			if (point.getY() < 0 || point.getY() > W){
				fail();
			}
			if (point.getX() < 0 && point.getX() > Q){
				fail();
			}
		}
	}
	
}
