package com.vg.task19.timzoneadjuster;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class TestNewDateApi {

	@Test
	public void test1() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

		LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
		System.out.println(localDateTime1);

		LocalDateTime localDateTime2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(localDateTime2);

		// 自定义：下一个工作日
		LocalDateTime localDateTime3 = localDateTime.with((l) -> {
			LocalDateTime ldt4 = (LocalDateTime) l;
			DayOfWeek dayOfWeek = ldt4.getDayOfWeek();
			if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
				return ldt4.plusDays(3);
			} else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
				return ldt4.plusDays(2);
			} else {
				return ldt4.plusDays(1);
			}
		});
		System.out.println(localDateTime3);
	}
}
