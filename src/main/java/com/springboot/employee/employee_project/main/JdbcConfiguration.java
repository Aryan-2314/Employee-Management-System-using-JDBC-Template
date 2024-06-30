package com.springboot.employee.employee_project.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springboot.employee.employee_project.dao.EmployeeDaoImpl;

@Configuration
public class JdbcConfiguration 
{
	@Bean("ds")
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:8080/employee");
		ds.setUsername("root");
		ds.setPassword("password");
		return ds;
	}
	
	@Bean("jdbcTemp")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;	
	}
	
	@Bean("employeedao")
	public EmployeeDaoImpl getDao()
	{
		EmployeeDaoImpl employeedao = new EmployeeDaoImpl();
		employeedao.setJdbcTemplate(getTemplate());
		return employeedao;
	}	
}
