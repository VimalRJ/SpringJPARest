package com.test.jpa.repository;

import java.util.List;

public interface IEmployee {

	List<Employee> getAllEmployee();

	Employee addEmployee(Employee employee);
	
	boolean isEmployeeExist(String id);

	void updateEmployee(Employee employee);

	void deleteEmployee(String employee);
	
	Employee getEmployee(String id);
}
