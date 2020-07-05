package com.vg.task11.match;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

import com.vg.task2.lambda.Employee;
import com.vg.task2.lambda.Employee.STATUS;

/**
 * 3） 终止操作
 *
 */
public class TestStreamApi {

	final List<Employee> listEmployee = Arrays.asList(
			new Employee("王洪", 35, new BigDecimal(29000), STATUS.FREE),
			new Employee("赵武", 32, new BigDecimal(12000), STATUS.BUSY),
			new Employee("李白", 32, new BigDecimal(17000), STATUS.VOCATION),
			new Employee("刘明明", 25, new BigDecimal(4800), STATUS.FREE),
			new Employee("洪吴", 22, new BigDecimal(4000), STATUS.BUSY)
		);
	
	/**
	 *	查找与匹配
	 *	allMartch 检查是否匹配所有元素
	 * anyMatch 检查是否至少匹配一个元素
	 * noneMatch 检查是否没有匹配所有元素
	 *	findFirst 返回第一个元素
	 *	findAny 查询满足条件的元素
	 *	count 返回流中元素总个数
	 *	max 返回流中最大值
	 *  min 返回流中最小值
	 */
	
	@Test
	public void test1() {
		System.out.println("test1 start...");

		boolean isAllBusy = listEmployee.stream()
				.allMatch(e -> e.getStatus().equals(STATUS.BUSY));
		System.out.println("isAllBusy=" + isAllBusy);

		boolean isAnyOneBusy = listEmployee.stream()
				.anyMatch(e -> e.getStatus().equals(STATUS.BUSY));
		System.out.println("isAnyOneBusy=" + isAnyOneBusy);

		boolean isNoneBusy = listEmployee.stream()
				.noneMatch(e -> e.getStatus().equals(STATUS.BUSY));
		System.out.println("isNoneBusy=" + isNoneBusy);
		
		Optional<Employee> op = listEmployee.stream()
				.sorted((x,y)-> x.getSalary().compareTo(y.getSalary()))
				.findFirst();
		if(op.isPresent()) {
			System.out.println("findFirstEmployee=" + op.get());
		}else {
			System.out.println("findFirstEmployee=null");
		}
		
		Optional<Employee> op2 =listEmployee.parallelStream() //并行流
			.filter(e->e.getStatus().equals(STATUS.FREE))
			.findAny();
		System.out.println("findAny op2="+op2.get());
		
	}
	
	@Test
	public void test2() {
		long count = listEmployee.stream().count();
		System.out.println("test2, count="+count);
		
		Optional<Employee> optional =listEmployee.stream()
			.max((x,y)->x.getSalary().compareTo(y.getSalary()));
		System.out.println("test2, optional="+optional.get());
		
		Optional<BigDecimal> optional2 = listEmployee.stream()
			.map(Employee::getSalary)
			.min((x,y)->x.compareTo(y));
		System.out.println("test2, optional2="+optional2.get());
	}
	
}
