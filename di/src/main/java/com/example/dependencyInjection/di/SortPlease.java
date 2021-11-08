package com.example.dependencyInjection.di;

public class SortPlease {
	
	private SortAlgorithm srt;
	
	public SortPlease(SortAlgorithm srt) {
		System.out.println("Using Constructor");
		this.srt = srt;
	}
	
	public void sortResult() {
		srt.sort(null);
	}
	

}
