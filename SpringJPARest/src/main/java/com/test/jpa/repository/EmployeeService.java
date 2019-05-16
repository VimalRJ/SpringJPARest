package com.test.jpa.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployee{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public boolean isEmployeeExist(String id) {
		return employeeDao.existsById(new Integer(id));
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.save(employee);
		
	}

	@Override
	public void deleteEmployee(String id) {
		employeeDao.deleteById(new Integer(id));
	}

	@Override
	public Employee getEmployee(String id) {
		
		try {
		
			return employeeDao.findById(new Integer(id)).get();
		
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return new Employee();
	}
	
}


