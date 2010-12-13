package com.lenochka.laba6.convex;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.lenochka.laba6.convex.Point;

public class PointTest {
	
	@Test
	public void compareCommon(){
		Point p1 = new Point(10f, 10f);
		Point p2 = new Point(8f, 10f);
		Assert.assertTrue(p1.compareTo(p2) < 0);
		Assert.assertTrue(p2.compareTo(p1) > 0);
	}
	
	@Test
	public void compareAngle(){
		Point p1 = new Point(10f, 20f);
		Point p2 = new Point(20f, 10f);
		Assert.assertTrue(p1.compareTo(p2) > 0);
		Assert.assertTrue(p2.compareTo(p1) < 0);
	}
	
	@Test
	public void compareRadius(){
		Point p1 = new Point(10f, 20f);
		Point p2 = new Point(20f, 40f);
		Assert.assertTrue(p1.compareTo(p2) < 0);
		Assert.assertTrue(p2.compareTo(p1) > 0);
	}
	
	@Test
	public void compareEquals(){ 
		// Очень нехорошо сравнивать на равенство вещественные значения
		// но в этом случае должно работать
		Point p1 = new Point(10f, 20f);
		Point p2 = new Point(10f, 20f);
		Assert.assertTrue(p1.compareTo(p2) == 0);
	}
	
	@Test
	public void sortingTest(){ 
		Point[] points = new Point[]{
				new Point(8f, 10f),
				new Point(10f, 9f),
				new Point(9f, 10f),
				new Point(10f, 10f),
				new Point(10f, 8f)};
		
		Point[] expected = new Point[]{
				new Point(10f, 8f),
				new Point(10f, 9f),
				new Point(10f, 10f),
				new Point(9f, 10f),
				new Point(8f, 10f)};
		
		Arrays.sort(points);		
		Assert.assertArrayEquals(expected, points);
	}

}
