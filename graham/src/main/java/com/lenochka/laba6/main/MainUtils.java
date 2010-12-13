package com.lenochka.laba6.main;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.lenochka.laba6.benchmark.BenchmarkNVariable;
import com.lenochka.laba6.benchmark.BenchmarkQVariable;
import com.lenochka.laba6.benchmark.Experimentator;
import com.lenochka.laba6.benchmark.SourceGeneratorInside;
import com.lenochka.laba6.benchmark.SourceGeneratorOnBorder;
import com.lenochka.laba6.convex.ConvexHull;
import com.lenochka.laba6.sort.SortAlgorithmDHeap;

public class MainUtils {
	
	public static void task31(Float q, Float w, Integer nFrom, Integer nTo, Integer nStep){
		XYSeries series1 = new BenchmarkNVariable(new Experimentator(
				new ConvexHull(SortAlgorithmDHeap.SORT_ALGORITHM_2HEAP),
				new SourceGeneratorInside(5)), q, w, nFrom, nTo, nStep)
				.benchmark();

		XYSeries series2 = new BenchmarkNVariable(new Experimentator(
				new ConvexHull(SortAlgorithmDHeap.SORT_ALGORITHM_3HEAP),
				new SourceGeneratorInside(5)), q, w, nFrom, nTo, nStep)
				.benchmark();

		XYSeries series3 = new BenchmarkNVariable(new Experimentator(
				new ConvexHull(SortAlgorithmDHeap.SORT_ALGORITHM_2HEAP),
				new SourceGeneratorOnBorder(5)), q, w, nFrom, nTo, nStep)
				.benchmark();

		XYSeries series4 = new BenchmarkNVariable(new Experimentator(
				new ConvexHull(SortAlgorithmDHeap.SORT_ALGORITHM_3HEAP),
				new SourceGeneratorOnBorder(5)), q, w, nFrom, nTo, nStep)
				.benchmark();


		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		dataset.addSeries(series4);

		JFreeChart chart = ChartFactory.createXYLineChart("Экспиримент q = "
				+ q + ", w = " + w + ", n = " + nFrom + ",...," + nTo
				+ ", с шагом " + nStep, 
				"n", 
				"Время, мс", 
				dataset,
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false 
				);
		try {
			File outputFile = new File("Main31.jpg");
			ChartUtilities.saveChartAsJPEG(outputFile, chart, 1024,
					768);
			System.out.println("График сохранен в файл: " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Неудалось сохранить файл");
		}
	}
		
		
	
	public static void task32(Integer n, Float qFrom, Float qTo, Float qStep) {
		XYSeries series1 = new BenchmarkQVariable(new Experimentator(
				new ConvexHull(SortAlgorithmDHeap.SORT_ALGORITHM_2HEAP),
				new SourceGeneratorInside(5)), n, qFrom, qTo, qStep)
				.benchmark();

		XYSeries series2 = new BenchmarkQVariable(new Experimentator(
				new ConvexHull(SortAlgorithmDHeap.SORT_ALGORITHM_3HEAP),
				new SourceGeneratorInside(5)), n, qFrom, qTo, qStep)
				.benchmark();

		// Add the series to your data set
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		// Generate the graph
		JFreeChart chart = ChartFactory.createXYLineChart("Экспиримент q = w ="
				+ qFrom + ",...," + qTo + " с шагом "+ qStep + ", n = " + n, 
				"q=w", 
				"Время, мс", 
				dataset,
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false 
				);
		try {
			File outputFile = new File("Main32.jpg");
			ChartUtilities.saveChartAsJPEG(outputFile, chart, 1024,
					768);
			System.out.println("График сохранен в файл: " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Неудалось сохранить файл");
		}
	}
		
	
	public static void task33(Integer n, Float qFrom, Float qTo, Float qStep) { 
		XYSeries series1 = new BenchmarkQVariable(new Experimentator(
				new ConvexHull(SortAlgorithmDHeap.SORT_ALGORITHM_2HEAP),
				new SourceGeneratorOnBorder(50)), n, qFrom, qTo, qStep)
				.benchmark();

		XYSeries series2 = new BenchmarkQVariable(new Experimentator(
				new ConvexHull(SortAlgorithmDHeap.SORT_ALGORITHM_3HEAP),
				new SourceGeneratorOnBorder(50)), n, qFrom, qTo, qStep)
				.benchmark();

		// Add the series to your data set
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		// Generate the graph
		JFreeChart chart = ChartFactory.createXYLineChart("Экспиримент q = w ="
				+ qFrom + ",...," + qTo + " с шагом "+ qStep + ", n = " + n, 
				"q=w", 
				"Время, мс", 
				dataset,
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				false 
				);
		try {
			File outputFile = new File("Main33.jpg");
			ChartUtilities.saveChartAsJPEG(outputFile, chart, 1024,
					768);
			System.out.println("График сохранен в файл: " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Неудалось сохранить файл");
		}
	}
	
	
}
