package com.example.dependencyInjection.di;

import org.springframework.stereotype.Component;

//@Component
public interface SortAlgorithm {
	
	public int[] sort(int[] vals);

}
