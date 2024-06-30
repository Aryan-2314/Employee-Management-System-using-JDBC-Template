package com.springboot.employee.employee_project.dao;
import java. util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.employee.employee_project.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	public int createTable()
//	{
//		//creating a table
//		String query="create table if not exits employees(int emp_id primary key,varchar(40) name,varvhar(40) salary,varchar(20) department,date joining_date,date departure_date,bool active";
//		int result=this.jdbcTemplate.update(query);
//		return result;
//	}
	
	@Override
	public int insert(EmployeeEntity employeeentity) 
	{
		//inserting an employee detail
		 String query="insert into employees(emp_id,name,salary,department,joining_date,departure_date,active) values()";
		 int result=this.jdbcTemplate.update(query,employeeentity.getId(),employeeentity.getName(),employeeentity.getSalary(),employeeentity.getDepartment(),employeeentity.getJoining_date(),employeeentity.getDeparture_date(),employeeentity.isActive());
		 return result;
	}
	
	@Override
	public int updateEmployee(EmployeeEntity employeeentity,int id) 
	{
		//Updating the employee details
		String query = "update employees set name=?, salary=?, department=?, joining_date=?, departure_date=?, active=? where emp_id=?";
		int result=this.jdbcTemplate.update(query,employeeentity.getId(),employeeentity.getName(),employeeentity.getSalary(),employeeentity.getDepartment(),employeeentity.getJoining_date(),employeeentity.getDeparture_date(),employeeentity.isActive());
		return result;
	}

    @Override
	public int deleteById(int emp_id) {
		// delete employee by id 
    	String query = "delete from employees where emp_id=?";
    	int result=this.jdbcTemplate.update(query,emp_id);
		return result;
	}
	
    @Override
	public List<EmployeeEntity> showAll() 
	{
		//Select all employee
		List<EmployeeEntity> list = new List<EmployeeEntity>();
		RowMapper<EmployeeEntity> rowMapper = new RowMapper();
		String query="select * from employees";
		list=this.jdbcTemplate.query(query,rowMapper);
		return list;
	}

	@Override
	public EmployeeEntity getById(int id) 
	{
		// Showing single employee by id
		EmployeeEntity employeeentity;
		RowMapper<EmployeeEntity> rowMapper = new RowMapper();
		String query="select emp_id,name,salary,department,joining_date,departure_date,active from employees where emp_id=?";
		employeeentity=(EmployeeEntity) this.jdbcTemplate.query(query,rowMapper,id);
		return employeeentity ;
	}

	public JdbcTemplate setJdbcTemplate(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate=jdbcTemplate;
		return jdbcTemplate;
	}
}