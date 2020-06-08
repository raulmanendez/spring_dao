package com.base.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.base.dao.DepartmentDAO;
import com.base.model.Department;

@RequestMapping("/dept")
@Controller
public class DepartmentController {

@Autowired
DepartmentDAO dao;
	
@RequestMapping("/add")
public String AddDepartment(Model DeptModel)
{
	Department dept=new Department();
	DeptModel.addAttribute("DepartmentModel",dept);
	
	List<Department> list=dao.getDepartments();
	DeptModel.addAttribute("department_list", list);
	
	return "department_page";
}
@RequestMapping(value="/save_new_dept",method=RequestMethod.POST)
public String save_department(@Valid @ModelAttribute("DepartmentModel") Department dept,BindingResult br,Model DeptModel)
{
	if(br.hasErrors())
	{
		List<Department> list=dao.getDepartments();
		DeptModel.addAttribute("department_list", list);
		
		return "department_page";
	}
	else
	{
		dao.save(dept);
		return "redirect:add";	
	}

}
	
}
