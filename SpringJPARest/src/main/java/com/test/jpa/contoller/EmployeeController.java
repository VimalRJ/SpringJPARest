package com.test.jpa.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.jpa.repository.Employee;
import com.test.jpa.repository.IEmployee;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployee employeeRepository;

	@GetMapping(path = "/emp/exist/{id}", produces = "application/json")
	public @ResponseBody String isExist(@PathVariable("id") String id) {
		String resp = "{\n       \"Status\": \"#RESP#\"\n       \n    }";
		resp = employeeRepository.isEmployeeExist(id) ? resp.replace("#RESP#", "User Exist"): resp.replace("#RESP#", "Does not exist");
		return resp;
	}

	@GetMapping(path = "/emp/{id}", produces = "application/json")
	public @ResponseBody Employee getEmployee(@PathVariable("id") String id) {
		return employeeRepository.getEmployee(id);
	}

	@PostMapping(path = "/emp", consumes = "application/json", produces = "application/json")
	public @ResponseBody Employee addEmployee(@RequestBody Employee employeei) {
		Employee emp = employeeRepository.addEmployee(employeei);
		return emp;
	}

	@GetMapping(path = "/emp/all", produces = "application/json")
	public @ResponseBody List<Employee> getAllEmployee() {
		return employeeRepository.getAllEmployee();
	}

	@DeleteMapping(path = "/emp/{id}", produces = "application/json")
	public @ResponseBody Boolean deleteEmployee(@PathVariable("id") String id) {
		employeeRepository.deleteEmployee(id);
		return true;
	}
}
