package com.learn.redis.service;

import com.learn.redis.model.Employee;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public interface EmployeeService {


    public void saveEmployee(Employee employee);

    public List<Employee> findAll();

    public Employee findById(Long id);

    public void update(Employee employee);

    public void delete(Long id);
}
