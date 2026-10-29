package com.amazone.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazone.Entity.EmployeeEntity;
import com.amazone.employee.Employee;
import com.amazone.employee.EmployeeResponse;
import com.amazone.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
     EmployeeService employeeService;
    
    @PostMapping("/employeeDetails")
    public EmployeeResponse createEmployeeDetails(@RequestBody EmployeeEntity request) {

        return employeeService.createEmployee(request);
    }


    @GetMapping("/{id}")
    public EmployeeResponse getEmployee(@PathVariable int id) {

        EmployeeEntity employee = employeeService.getEmployeeById(id);

        EmployeeResponse response = new EmployeeResponse();
        response.setStatusCode(200);
        response.setMessage("Employee fetched successfully");
        response.setEmployee(employee);
        response.setTimestamp(LocalDateTime.now().toString());
        response.setSuccess(true);

        return response;
    }

    @PostMapping
    public EmployeeResponse createEmployee(@RequestBody EmployeeEntity employee) {

        EmployeeEntity savedEmployee = employeeService.saveEmployee(employee);

        EmployeeResponse response = new EmployeeResponse();
        response.setStatusCode(201);
        response.setMessage("Employee created successfully");
        response.setEmployee(savedEmployee);
        response.setTimestamp(LocalDateTime.now().toString());
        response.setSuccess(true);

        return response;
    }
    @GetMapping("/findbyname")
    public EmployeeResponse findByName(@RequestParam ("empName") String empName)
    {
    	return (EmployeeResponse) employeeService.findByEmpName(empName);
    }
}

