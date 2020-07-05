package com.vg.task14.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculator extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 558925568861618826L;

	private long start;
	private long end;
	private static final long THRESHOLD = 10000;
	
	public ForkJoinCalculator(long start, long end) {
		this.start = start;
		this.end = end;
	}
	@Override
	protected Long compute() {
		long length = end - start;
		if(length<=THRESHOLD) {
			long sum = 0;
			for(long i=start; i<=end; i++) {
				sum  += i;
			}
			return sum;
		}else {
			long middle = (start+end)/2;
			ForkJoinCalculator leftCalculator = new ForkJoinCalculator(start, middle);
			leftCalculator.fork();
			
			ForkJoinCalculator rightCalculator = new ForkJoinCalculator(middle+1, end);
			rightCalculator.fork();
			
			return leftCalculator.join()+rightCalculator.join();
		}
	}

}
