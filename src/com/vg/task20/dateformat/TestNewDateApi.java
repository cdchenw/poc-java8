package com.vg.task20.dateformat;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class TestNewDateApi {

	/**
	 * 1. DateTimeFormatter: 格式化日期/时间
	 * 2. ZonedDate\ZonedTime\ZoneDateTime
	 * 
	 */
	
	@Test
	public void test1() {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime ldt = LocalDateTime.now();
		
		String strDate = ldt.format(dtf);
		System.out.println("iso_date_time="+strDate);
		
		//自定义formater
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String strDate1 = ldt.format(dtf2);
		System.out.println("customized formater="+strDate1);
		
		LocalDateTime newDateTime = ldt.parse(strDate1, dtf2);
		System.out.println("parsed time="+newDateTime);
		
	}
	
	@Test
	public void test2() {
//		ZoneId.getAvailableZoneIds().forEach(System.out::println);  //支持的时区
		LocalDateTime ldDateTime = LocalDateTime.now(ZoneId.of("Europe/Nicosia"));
		System.out.println("europe time now="+ldDateTime);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zdt = localDateTime.atZone(ZoneId.of("Europe/Nicosia"));
		System.out.println("europe zone datetime now="+zdt);
	}
}
