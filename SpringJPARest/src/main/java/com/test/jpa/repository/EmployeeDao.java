package com.test.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	
	
	@SuppressWarnings("unchecked")
	Employee save(Employee employee);
	
	boolean existsById(Integer id);
	
	List<Employee> findAll();
	
	void deleteById(Integer id);

	Optional<Employee> findById(Integer integer);

}