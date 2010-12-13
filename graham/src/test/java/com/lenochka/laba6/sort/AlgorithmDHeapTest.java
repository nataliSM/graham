package com.lenochka.laba6.sort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class AlgorithmDHeapTest {
	
	private static Random random = new Random(100);
	private static int MAX_SIZE = 155055;
	
	public Integer[] rndData(){
		Integer[] data  = new Integer[MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			data[i] = random.nextInt();
		}
		return data;
	}

	@Test
	public void sortFullTest() {
		for (int d = 2; d < 3; d++) {		
			Integer[] data = rndData();
			Integer[] dataExpected = Arrays.copyOf(data, data.length);
			Arrays.sort(dataExpected); // Эталлонная сортировка Arrays.sort
			new SortAlgorithmDHeap(d).sort(data);	
			Assert.assertArrayEquals(dataExpected, data);			
		}
	}
	
	@Test
	public void sortSimleTest2Heap() {
		Integer[] data = new Integer[]{1,10,2,12,11,11};
		Integer[] dataExpected = new Integer[]{1,2,10,11,11,12};
		SortAlgorithmDHeap.SORT_ALGORITHM_2HEAP.sort(data);
		Assert.assertArrayEquals(dataExpected, data);	
	}
	
	@Test
	public void sortSimleTest3Heap() {
		Integer[] data = new Integer[]{1,10,2,12,11,11};
		Integer[] dataExpected = new Integer[]{1,2,10,11,11,12};
		SortAlgorithmDHeap.SORT_ALGORITHM_3HEAP.sort(data);
		Assert.assertArrayEquals(dataExpected, data);		
	}
	

}
