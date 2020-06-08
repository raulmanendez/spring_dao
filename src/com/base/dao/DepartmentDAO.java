package com.base.dao;

import java.sql.ResultSet;
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.base.model.Department;
import com.base.model.Emp;
public class DepartmentDAO {
     
JdbcTemplate template;    
    
public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}    
public int save(Department dept){    
    String sql="insert into department(branch_code,department_code,department_name) values('"+dept.getBranchCode()+"',"+dept.getDepartmentCode()+",'"+dept.getDepartmentName()+"')";    
    return template.update(sql);    
}
public List<Department> getDepartments(){    
    return template.query("select * from department",new RowMapper<Department>(){    
        public Department mapRow(ResultSet rs, int row) throws SQLException {    
            Department e=new Department();    
            e.setBranchCode(rs.getString(1));    
            e.setDepartmentCode(rs.getString(2));    
            e.setDepartmentName(rs.getString(3));    
            return e;    
        }    
    });    
}
}