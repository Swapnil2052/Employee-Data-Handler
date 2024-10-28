package com.example.crudMVC.dao;

import com.example.crudMVC.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findByID(int theid);
    Employee save(Employee theEmployee);
    void deleteByID(int theid);
}
