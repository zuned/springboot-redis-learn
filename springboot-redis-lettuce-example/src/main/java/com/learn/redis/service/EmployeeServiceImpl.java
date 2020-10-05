package com.learn.redis.service;

import com.learn.redis.model.Employee;
import com.learn.redis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.saveEmployee(employee);
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public void update(Employee employee) {
        this.employeeRepository.update(employee);
    }

    @Override
    public void delete(Long id) {
        this.delete(id);
    }
}
