package com.amazone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazone.Entity.EmployeeEntity;
import com.amazone.Repository.EmployeeDao;
import com.amazone.employee.Employee;
import com.amazone.employee.EmployeeResponse;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeRepository;
    
    public EmployeeResponse createEmployee(EmployeeEntity request) {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDepartment(request.getDepartment());

        EmployeeEntity savedEmployee = employeeRepository.save(request);

        EmployeeResponse response = new EmployeeResponse();
        response.setStatusCode(201);
        response.setMessage("Employee created successfully");
        response.setEmployee(savedEmployee);
        response.setSuccess(true);

        return response;
    }
    

    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }
   
    public EmployeeEntity getEmployeeById(int id) {
        return employeeRepository.getById(id);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
    
    
    public List<EmployeeResponse> findByEmpName(String name)
    {
    	
    	List<EmployeeEntity> employeeEntity = employeeRepository.findByName(name);
    	
    	List<EmployeeResponse> employeeResponses = new ArrayList<EmployeeResponse>();
    	
    	for (EmployeeEntity empResponse : employeeEntity) {
			
    		
    		 EmployeeResponse response = new EmployeeResponse();
    	        response.setStatusCode(201);
    	        response.setMessage("Employee created successfully");
    	        response.setEmployee(empResponse);
    	        
    	        response.setSuccess(true);
    	        
    	        employeeResponses.add(response);
		}
    	
    	return employeeResponses;
    	
    	
    }
}
