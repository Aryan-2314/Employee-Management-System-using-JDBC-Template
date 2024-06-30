package com.springboot.employee.employee_project.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.employee.employee_project.entity.EmployeeEntity;

public interface EmployeeDao 
{
	int insert(EmployeeEntity employee_entity);
	int updateEmployee(EmployeeEntity employee_entity,int emp_id);
	int deleteById(int emp_id);
	List<EmployeeEntity> showAll();
	EmployeeEntity showById(int id);
	EmployeeEntity getById(int id);
}