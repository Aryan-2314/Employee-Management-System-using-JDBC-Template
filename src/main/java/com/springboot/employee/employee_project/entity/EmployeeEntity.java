package com.springboot.employee.employee_project.entity;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@EntityScan
@Table(name = "employees")
public class EmployeeEntity 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(value = "emp_id")
    private int id;

    @Column(value = "name")
    private String name;

    @Column(value = "salary")
    private int salary;

    @Column(value = "department")
    private String department;

    @Column(value = "joining_date")
    private Date joining_date;

    @Column(value = "departure_date")
    private Date departure_date;

    @Column(value = "active")
    private boolean active;

    public EmployeeEntity(int id, String name, int salary, String department, Date joining_date, Date departure_date, boolean active) 
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.joining_date = joining_date;
        this.departure_date = departure_date;
        this.active = active;
    }

    public EmployeeEntity()
    {
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", joining_date=" + joining_date +
                ", departure_date=" + departure_date +
                ", active=" + active +
                '}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
