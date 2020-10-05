package com.learn.redis.repository;

import com.learn.redis.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    public void saveEmployee(Employee employee);

    public List<Employee> findAll();

    public Employee findById(Long id);

    public void update(Employee employee);

    public void delete(Long id);
}
