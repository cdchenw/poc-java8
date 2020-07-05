package com.vg.task17.thread;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class TestThread {

	//线程安全问题
	@Test
	public void test1() throws InterruptedException, ExecutionException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		Callable<Date> task = new Callable<Date>() {

			@Override
			public Date call() throws Exception {
				return DateFormatThreadLocal.convert("20200704");
			}
		};
		
		List<Future<Date>> resultsList = new ArrayList<Future<Date>>();
		for(int i =0; i<10; i++) {
			resultsList.add(pool.submit(task));
		}
		
		for(Future<Date> future: resultsList) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}
	
	@Test
	public void test2() throws InterruptedException, ExecutionException {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		Callable<LocalDate> task = new Callable<LocalDate>() {

			@Override
			public LocalDate call() throws Exception {
				return LocalDate.parse("20200704", df);
			}
		};
		
		List<Future<LocalDate>> resultsList = new ArrayList<Future<LocalDate>>();
		for(int i =0; i<10; i++) {
			resultsList.add(pool.submit(task));
		}
		
		for(Future<LocalDate> future: resultsList) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}
}
