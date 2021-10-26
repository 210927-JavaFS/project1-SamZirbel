package com.revature.repos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
	
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeByCerealID(int cereal);
	
	// VV Post Is For Additions
	public boolean postEmployee(Employee employee);
	
	// VV Put Is For Updates
	public boolean putEmployee(Employee employee);
	
	public boolean deleteEmployee(Employee employee);
	
}
