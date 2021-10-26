package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repos.EmployeeDAO;
import com.revature.repos.EmployeeDAOImpl;

public class EmployeeService {
	
	private EmployeeDAO employeedao = new EmployeeDAOImpl();

	public List<Employee> getAllEmployees() {
		
		return employeedao.getAllEmployees();
		
	}
	
	public Employee getEmployeeByCerealID(int cereal) {
		
		Employee employee = employeedao.getEmployeeByCerealID(cereal);
		
		return (employee != null) ? employee : new Employee();
		
	}
	
	// VV Post Is For Additions
	public boolean postEmployee(Employee employee) {
	
		return employeedao.postEmployee(employee);
		
	}
	
	// VV Put Is For Updates
	public boolean putEmployee(Employee employee) {
		
		return employeedao.putEmployee(employee);
		
	}
	
	public boolean deleteEmployee(Employee employee) {
		
		return employeedao.deleteEmployee(employee);
		
	}
	
}
