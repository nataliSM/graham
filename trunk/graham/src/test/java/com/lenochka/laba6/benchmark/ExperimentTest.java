/**
 * 
 */
package com.lenochka.laba6.benchmark;

import org.junit.Test;

import com.lenochka.laba6.convex.ConvexHull;
import com.lenochka.laba6.sort.SortAlgorithmDHeap;

/**
 * @author Lenochka
 *
 */
public class ExperimentTest {
	
	@Test
	public void experiment(){
		long result = new Experimentator(new ConvexHull(SortAlgorithmDHeap.SORT_ALGORITHM_2HEAP), 
				new SourceGeneratorInside(55)).experement(100F, 1000F, 10000);
	}

}
