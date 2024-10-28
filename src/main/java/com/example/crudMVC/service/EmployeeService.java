package com.example.crudMVC.service;

import com.example.crudMVC.Employee;
import java.util.*;

public interface EmployeeService {
    List<Employee>findAll();
    Employee findByID(int theid);
    Employee save(Employee theEmployee);
    void deleteByID(int theid);

}
