package com.amazone.employee;

import com.amazone.Entity.EmployeeEntity;

public class EmployeeResponse {

    private int statusCode;
    private String message;
    private EmployeeEntity employee;
    private String timestamp;
    private boolean success;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EmployeeEntity getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeEntity savedEmployee) {
		this.employee = savedEmployee;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
    
}

