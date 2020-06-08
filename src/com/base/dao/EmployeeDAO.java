package com.base.dao;

import java.util.List;

import com.base.model.EmployeeVO;
 
public interface EmployeeDAO
{
    public List<EmployeeVO> getAllEmployees();
}