/**
 * 
 */
package com.lenochka.laba6.benchmark;

import java.util.Random;

import com.lenochka.laba6.convex.Point;

/**
 * @author Lenochka
 * 
 */
public class SourceGeneratorInside implements SourceGenerator {

	private Random random;

	public SourceGeneratorInside(long randomSeed) {
		random = new Random(randomSeed);
	}

	/* (non-Javadoc)
	 * @see com.lenochka.laba6.benchmark.SourceGenerator#genarete(java.lang.Float, java.lang.Float, int)
	 */
	@Override
	public Point[] genarete(Float q, Float w, int n) {
		Point[] result = new Point[n];
		for (int i = 0; i < result.length; i++) {
			Float x, y;
			y = random.nextFloat() * w;
			x = random.nextFloat() * q;
			result[i] = new Point(x, y);
		}
		return result;
	}
	
	@Override
	public String toString(){
		return "Точки внутри прямоугольника.";
	}

}
