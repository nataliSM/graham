package com.lenochka.laba6.benchmark;

import org.jfree.data.xy.XYSeries;

public class BenchmarkQVariable implements Benchmarker{
	
	private Experimentator experimentator = null;
	private Integer n = null;
	private Float qFrom  = null;
	private Float qFor  = null;
	private Float qStep  = null;


	public BenchmarkQVariable(Experimentator experimentator, Integer n,
			Float qFrom, Float qFor, Float qStep) {
		super();
		this.experimentator = experimentator;
		this.n = n;
		this.qFrom = qFrom;
		this.qFor = qFor;
		this.qStep = qStep;
	}

	@Override
	public XYSeries benchmark() {
		System.out.println(this.toString() + "...");
		XYSeries series = new XYSeries(this.toString());
		for (Float q = qFrom; q<=qFor; q+=qStep) {
			series.add((Number)q, experimentator.experement(q, q, n));
		}
		System.out.println("\n");
		return series;
	}
	
	@Override
	public String toString(){
		return experimentator.toString() + "\nКоличество точек " + n + ", изменяется сторона квадрата";
	}

}
