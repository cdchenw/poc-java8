package com.vg.task14.forkjoin;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

/**
 * 1. 解决传统多线程，线程阻塞导致的效率问题
 * 2. 工作窃取模式
 * 3. 拆分任务也需要时间，超过临界值，数据量越大越明显
 *
 */
public class TestFork {

	@Test
	public void test1() {
		Instant startInstant = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculator(0, 10000000000L);
		long sum = pool.invoke(task);
		
		Instant endInstant = Instant.now();
		
		long spendTime = Duration.between(startInstant, endInstant).toMillis();
		
		System.out.println("test1: sum>>"+sum +"，spendTime="+spendTime+"ms");
	}
	
	@Test
	public void test2() {
		Instant startInstant = Instant.now();
		long sum = 0L;
		for(long i=0; i<10000000000L; i++) {
			sum += i;
		}
		Instant endInstant = Instant.now();
		long spendTime = Duration.between(startInstant, endInstant).toMillis();
		
		System.out.println("test2 :sum>>"+sum +"，spendTime="+spendTime+"ms");
	}
	
	/**
	 * java8 并行流
	 */
	@Test
	public void test3() {
		Instant startInstant1 = Instant.now();
		long result1 = LongStream.rangeClosed(0, 1000000000L)
			.reduce(0, Long::sum);   //顺序流
		Instant endInstant1 = Instant.now();
		long spendTime1 = Duration.between(startInstant1, endInstant1).toMillis();
		System.out.println("test3 :result1>>"+result1 +"，spendTime="+spendTime1+"ms");
		
		Instant startInstant2 = Instant.now();
		long result2 = LongStream.rangeClosed(0, 1000000000L)
			.parallel()  //切换成并行流
			.reduce(0, Long::sum);   
		Instant endInstant2 = Instant.now();
		long spendTime2 = Duration.between(startInstant2, endInstant2).toMillis();
		System.out.println("test3 :result2>>"+result2 +"，spendTime="+spendTime2+"ms");
	
		
	}
}
