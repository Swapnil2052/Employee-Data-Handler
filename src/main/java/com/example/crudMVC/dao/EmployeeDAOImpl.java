package com.example.crudMVC.dao;

import com.example.crudMVC.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    EntityManager entityManager;
@Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee>query=entityManager.createQuery(
                                         "from Employee", Employee.class);
        List<Employee>employees=query.getResultList();
        return employees;
    }

    @Override
    public Employee findByID(int theid) {
        Employee employee=entityManager.find(Employee.class, theid);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee=entityManager.merge(theEmployee);
        return employee;
    }

    @Override
    public void deleteByID(int theid) {
        Employee employee=entityManager.find(Employee.class,theid);
        entityManager.remove(employee);
    }
}
