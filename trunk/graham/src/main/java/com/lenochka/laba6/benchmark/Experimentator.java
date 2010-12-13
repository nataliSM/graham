package com.lenochka.laba6.benchmark;

import com.lenochka.laba6.convex.ConvexHull;
import com.lenochka.laba6.convex.Point;

/**
 * @author Lenochka
 *
 */
public class Experimentator {
	
	private ConvexHull convexHull = null;
	private SourceGenerator sourceGenerator = null;
	
	public Experimentator(
			ConvexHull convexHull, 
			SourceGenerator sourceGenerator) {
		super();
		this.convexHull = convexHull;
		this.sourceGenerator = sourceGenerator;
	}
	
	public long experement(Float q, Float w, int n){
		Point[] source = sourceGenerator.genarete(q, w, n);
		System.out.print(".");
		long time = System.currentTimeMillis();
		convexHull.convex(source);
		return System.currentTimeMillis() - time;
	}
	
	@Override
	public String toString(){
		return convexHull.toString() + " | " + sourceGenerator.toString();
	}
	
		
}
