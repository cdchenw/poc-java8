package com.vg.task4.lambdaexer;

@FunctionalInterface
public interface FunCalculator<T, R> {
	public  R getValue(T t1, T t2);
}
