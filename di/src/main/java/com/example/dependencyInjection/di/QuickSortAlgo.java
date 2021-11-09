package com.example.dependencyInjection.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgo implements SortAlgorithm{

	@Override
	public int[] sort(int[] vals) {
		// TODO Auto-generated method stub
		System.out.println("QuickSort Algorithm");
		return null;
	}

}
