package com.base.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Department {

private String status;
private String message;
//size validation
@Size(min=1,message="required") 
private String BranchCode;
@Size(min=1,message="required")
@Min(value=18, message="must be equal or greater than 18")  
@Max(value=45, message="must be equal or less than 45")  
//@Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")  
private String DepartmentCode;
@Size(min=1,message="required") 
private String DepartmentName;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getBranchCode() {
	return BranchCode;
}
public void setBranchCode(String branchCode) {
	BranchCode = branchCode;
}
public String getDepartmentCode() {
	return DepartmentCode;
}
public void setDepartmentCode(String departmentCode) {
	DepartmentCode = departmentCode;
}
public String getDepartmentName() {
	return DepartmentName;
}
public void setDepartmentName(String departmentName) {
	DepartmentName = departmentName;
}
}
