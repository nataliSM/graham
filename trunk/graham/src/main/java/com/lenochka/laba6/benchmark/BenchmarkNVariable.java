package com.lenochka.laba6.benchmark;

import org.jfree.data.xy.XYSeries;

public class BenchmarkNVariable implements Benchmarker{
	
	private Experimentator experimentator = null;
	private Float q = null;
	private Float w = null;
	private Integer nFrom  = null;
	private Integer nFor  = null;
	private Integer nStep  = null;

	public BenchmarkNVariable(Experimentator experimentator, Float q, Float w,
			Integer nFrom, Integer nFor, Integer nStep) {
		super();
		this.experimentator = experimentator;
		this.q = q;
		this.w = w;
		this.nFrom = nFrom;
		this.nFor = nFor;
		this.nStep = nStep;
	}

	@Override
	public XYSeries benchmark() {
		System.out.println(this.toString() + "...");
		XYSeries series = new XYSeries(this.toString());
		for (int n = nFrom; n<=nFor; n+=nStep) {
			series.add(n, experimentator.experement(q, w, n));
		}
		System.out.println("\n");
		return series;
	}
	
	@Override
	public String toString(){
		return experimentator.toString() + "\nПрямоугольник со сторонами "+ q +" x "+ w +", изменяется n";
	}

}
