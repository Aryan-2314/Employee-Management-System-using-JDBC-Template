package com.springboot.employee.employee_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.employee_project.dao.EmployeeDaoImpl;
import com.springboot.employee.employee_project.entity.EmployeeEntity;

@RestController
@RequestMapping("/employee")
public class Controller
{
    @Autowired
    private EmployeeDaoImpl employeedao;
    
	@GetMapping("/employee-detail")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee()
    {
        List<EmployeeEntity> list;
        list=employeedao.showAll();
        if(list.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/employee-detail/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeId(@PathVariable("id") int id)
    {
        EmployeeEntity employeeentity;
        employeeentity=employeedao.showById(id);
        if(employeeentity==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(employeeentity));
    }

    @PostMapping("/employee-detail/add")
    public ResponseEntity<Integer> addEmployee(EmployeeEntity employeeentity)
    {
    	try
    	{
        int employee;
        employee = employeedao.insert(employeeentity);
        return ResponseEntity.of(Optional.of(employee));
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }

    @DeleteMapping("/employee-detail/{id}")
    public ResponseEntity<Integer> deleteEmployee(@PathVariable("id") int id)
    {
    	try 
    	{
    		employeedao.deleteById(id);
    		return ResponseEntity.ok().build();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
        
    }

    @PutMapping("/employee-detail/{id}")
    public ResponseEntity<Integer> updateEmployee(EmployeeEntity employee , @PathVariable("id") int id)
    {
    	try
    	{
        int employeeentity;
        employeeentity = employeedao.updateEmployee(employee,id);
        return ResponseEntity.of(Optional.of(employeeentity));
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }
}
