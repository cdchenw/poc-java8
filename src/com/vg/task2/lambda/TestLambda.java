package com.vg.task2.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;


public class TestLambda {

	@Test
	public void testCompare() {
		Comparator<Integer> comp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
			
		};
		TreeSet<Integer> treeSet = new TreeSet<>(comp);
		treeSet.comparator();
	}
	
	//Lambda ���ʽ
	@Test
	public void testCompareNew() {
		Comparator<Integer> comp = (x,y)->Integer.compare(x, y);
		TreeSet<Integer> treeSet = new TreeSet<>(comp);
		treeSet.comparator();
	}
	
	final List<Employee> listEmployee = Arrays.asList(
		new Employee("����", 35, new BigDecimal(29000)),
		new Employee("���", 32, new BigDecimal(17000)),
		new Employee("����", 31, new BigDecimal(12000)),
		new Employee("������", 25, new BigDecimal(4800))
	);
	
	//���󣺲�ѯ�������30��Ա��
	@Test
	public void test2() {
		List<Employee> list = filterEmployees(listEmployee);
		for(Employee employee: list) {
			System.out.println("test2:"+employee);
		}
	}
	
	public List<Employee> filterEmployees(List<Employee> listEmployees){
		List<Employee> resultEmployees = new ArrayList<Employee>();
		for(Employee employee: listEmployees) {
			if(employee.getAge()>=30) {
				resultEmployees.add(employee);
			}
		}
		return resultEmployees;
	}
	
	//���󣺲�ѯ���ʴ���5000��Ա��
	@Test
	public void test3() {
		List<Employee> list = filterEmployeesBySalary(listEmployee);
		for(Employee employee: list) {
			System.out.println("test3:"+employee);
		}
	}
	
	public List<Employee> filterEmployeesBySalary(List<Employee> listEmployees){
		List<Employee> resultEmployees = new ArrayList<Employee>();
		for(Employee employee: listEmployees) {
			if(employee.getSalary().compareTo(new BigDecimal(5000))>=0) {
				resultEmployees.add(employee);
			}
		}
		return resultEmployees;
	}
		
	//�Ż���ʽ1, ����ģʽ
	@Test
	public void test4() {
		List<Employee> list = filterEmployee(listEmployee, new FilterEmployeeByAge());
		for(Employee employee: list) {
			System.out.println("test4:"+employee);
		}
	}
	
	@Test
	public void test5() {
		List<Employee> list = filterEmployee(listEmployee, new FilterEmployeeBySalary());
		for(Employee employee: list) {
			System.out.println("test5:"+employee);
		}
	}
	
	public <T> List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> predicate) {
		List<Employee> resultEmployees = new ArrayList<Employee>();
		
		for(Employee employee: list) {
			if(predicate.verify(employee)) {
				resultEmployees.add(employee);
			}
		}
		return resultEmployees;
	}
	
	//�Ż���ʽ2�� �����ڲ���
	@Test
	public void test6() {
		List<Employee> list = filterEmployee(listEmployee, new MyPredicate<Employee>() {
			@Override
			public boolean verify(Employee employee) {
				return employee.getSalary().compareTo(new BigDecimal(5000))<=0;
			}
		});
		for(Employee employee: list) {
			System.out.println("test6:"+employee);
		}
	}
	
	//�Ż�3��Lambda���ʽ
	@Test
	public void test7() {
		List<Employee> list = filterEmployee(listEmployee, (employee)->employee.getAge()>=30);
		for(Employee employee: list) {
			System.out.println("test7:"+employee);
		}
	}
	
	//�Ż�4: stream
	@Test
	public void test8() {
		listEmployee.stream().filter(e->{
			return e.getSalary().compareTo(new BigDecimal(5000))>0;
		}).limit(2)
		.forEach(System.out::println);
	}

}
