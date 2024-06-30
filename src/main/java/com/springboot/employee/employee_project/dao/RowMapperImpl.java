package com.springboot.employee.employee_project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.springboot.employee.employee_project.entity.EmployeeEntity;

class RowMapperImpl implements RowMapper<EmployeeEntity>
{

	public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		EmployeeEntity employeeentity = new EmployeeEntity();
		employeeentity.setId(rs.getInt("emp_Id"));
		employeeentity.setName(rs.getString("emp_name"));
		employeeentity.setSalary(rs.getInt("salary"));
		employeeentity.setDepartment(rs.getString("department"));
		employeeentity.setJoining_date(rs.getDate("joining_date"));
		employeeentity.setDeparture_date(rs.getDate("departure_date"));
		employeeentity.setActive(rs.getBoolean("active"));
		return employeeentity;
	}
}
