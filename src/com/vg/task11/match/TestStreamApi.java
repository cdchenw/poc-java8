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
 * 3�� ��ֹ����
 *
 */
public class TestStreamApi {

	final List<Employee> listEmployee = Arrays.asList(
			new Employee("����", 35, new BigDecimal(29000), STATUS.FREE),
			new Employee("����", 32, new BigDecimal(12000), STATUS.BUSY),
			new Employee("���", 32, new BigDecimal(17000), STATUS.VOCATION),
			new Employee("������", 25, new BigDecimal(4800), STATUS.FREE),
			new Employee("����", 22, new BigDecimal(4000), STATUS.BUSY)
		);
	
	/**
	 *	������ƥ��
	 *	allMartch ����Ƿ�ƥ������Ԫ��
	 * anyMatch ����Ƿ�����ƥ��һ��Ԫ��
	 * noneMatch ����Ƿ�û��ƥ������Ԫ��
	 *	findFirst ���ص�һ��Ԫ��
	 *	findAny ��ѯ����������Ԫ��
	 *	count ��������Ԫ���ܸ���
	 *	max �����������ֵ
	 *  min ����������Сֵ
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
		
		Optional<Employee> op2 =listEmployee.parallelStream() //������
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
