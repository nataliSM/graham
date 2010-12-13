package com.lenochka.laba6.convex;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import com.lenochka.laba6.convex.ConvexHull;
import com.lenochka.laba6.convex.Point;
import com.lenochka.laba6.sort.SortAlgorithmDHeap;

public class ConvexHullTest {
	
	@Test
	public void conv1(){
		Point[] points = new Point[]{
				new Point(10f, 10f),
				new Point(-10f, -10f),
				new Point(0f, 0f),
				new Point(0f, 0f),
				new Point(5f, 5f),
				new Point(10f, -10f),
				new Point(-10f, 10f),
				new Point(11f, 0f),
				new Point(-10f, 0f)};
		
		Point[] expected = new Point[]{
				new Point(10f, 10f),
				new Point(-10f, -10f),
				new Point(10f, -10f),
				new Point(-10f, 10f),
				new Point(11f, 0f)};

		int m = new ConvexHull(new SortAlgorithmDHeap(3)).convex(points);
		Point[] result = Arrays.copyOf(points, m + 1);
		Assert.assertEquals(new HashSet<Point>(Arrays.asList(expected)), new HashSet<Point>(Arrays.asList(result)));
		
	}
	
	@Test
	public void conv2(){
		Point[] points = new Point[]{
				new Point(10f, 10f),
				new Point(-10f, -10f),
				new Point(0f, 0f),
				new Point(5f, 500f),
				new Point(10f, -10f),
				new Point(-10f, 10f),
				new Point(7f, 0f),
				new Point(-10f, 0f)};
		
		Point[] expected = new Point[]{
				new Point(10f, 10f),
				new Point(-10f, -10f),
				new Point(10f, -10f),
				new Point(-10f, 10f),
				new Point(5f, 500f)};

		int m = new ConvexHull(new SortAlgorithmDHeap(3)).convex(points);
		Point[] result = Arrays.copyOf(points, m + 1);
		Assert.assertEquals(new HashSet<Point>(Arrays.asList(expected)), new HashSet<Point>(Arrays.asList(result)));
		
	}

}
