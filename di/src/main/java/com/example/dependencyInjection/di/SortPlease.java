package com.example.dependencyInjection.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SortPlease {
	
	@Autowired
	private SortAlgorithm srt;
	
	public SortPlease(SortAlgorithm srt) {
		System.out.println("Using Constructor");
		this.srt = srt;
	}
	
	public void sortResult() {
		srt.sort(null);
	}
	

}
