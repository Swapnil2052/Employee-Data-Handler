package com.example.crudMVC.service;

import com.example.crudMVC.Employee;
import com.example.crudMVC.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDAO employeeDAO;
@Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findByID(int theid) {
        return employeeDAO.findByID(theid);
    }
@Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }
@Transactional
    @Override
    public void deleteByID(int theid) {
      employeeDAO.deleteByID(theid);
    }
}
