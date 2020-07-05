package com.vg.task18.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;

import org.junit.Test;

public class TestLocalDateTime {

	/**
	 * 1. LocalDate 、LocalTime 、 LocalDateTime
	 */
	@Test
	public void test1() {
		System.out.println("---------------------test1-------------------------------");
		LocalDateTime ldt  = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ldt2 = LocalDateTime.of(2020, 10, 19, 13,22, 33);
		System.out.println(ldt2);
		
		LocalDateTime ldt3 = ldt.plusDays(7);
		System.out.println(ldt3);
		
		LocalDateTime ldt4 = ldt.minusMonths(10);
		System.out.println(ldt4);
		
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonth().getValue());
		
	}
	
	/**
	 * 2. Instant: 时间戳(以unix元年1970年1月1日当 某个时间的毫秒值)
	 */
	@Test
	public void test2() {
		System.out.println("---------------------test2-------------------------------");
		Instant instant1 = Instant.now();  //默认获取UTC市区 （即：世界协调时间）
		System.out.println(instant1);
		
		OffsetDateTime offsetDateTime = instant1.atOffset(ZoneOffset.ofHours(8));  //加8小时时差的便宜时间
		System.out.println(offsetDateTime);
		System.out.println(offsetDateTime.toEpochSecond());  //毫秒数
		
		Instant instant2 = Instant.ofEpochSecond(60);
		System.out.println(instant2);
		
	}
	
	/**
	 * 3. Duration: 试算两个“时间”的间隔
	 *     Period： 计算两个“日期“的间隔
	 */
	@Test
	public void test3() {
		System.out.println("---------------------test3-------------------------------");
		Instant instant1 = Instant.now();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Instant instant2 = Instant.now();
		
		Duration duration = Duration.between(instant1, instant2);
		System.out.println(duration.getSeconds());
		
		LocalTime lt1 = LocalTime.now();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LocalTime lt2 = LocalTime.now();
		Duration duration1 = Duration.between(lt1, lt2);
		System.out.println(duration1.getSeconds());
		
	}
	
	@Test
	public void test4() {
		System.out.println("---------------------test4-------------------------------");
		LocalDate ld1 = LocalDate.of(2015, 1, 1);
		LocalDate ld2 = LocalDate.of(2018, 1, 1);	
				
		Period period = Period.between(ld1, ld2);
		System.out.println(period.toString());
	}
}
