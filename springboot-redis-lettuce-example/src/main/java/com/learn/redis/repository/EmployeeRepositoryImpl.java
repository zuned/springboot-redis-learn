package com.learn.redis.repository;

import com.learn.redis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements  EmployeeRepository {

    private final HashOperations hashOperations;
    private final RedisTemplate redisTemplate;
    private static final String REDIS_HASH_KEY = "EMPLOYEE";
    @Autowired
    public EmployeeRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations=redisTemplate.opsForHash();
    }

    @Override
    public void saveEmployee(Employee employee){
        this.hashOperations.put(REDIS_HASH_KEY,employee.getId(),employee);
    }

    @Override
    public List<Employee> findAll(){
        return this.hashOperations.values(REDIS_HASH_KEY);
    }

    @Override
    public Employee findById(Long id){
        return (Employee) this.hashOperations.get(REDIS_HASH_KEY,id);

    }
    @Override
    public void update(Employee employee){
        saveEmployee(employee);
    }

    @Override
    public void delete(Long id){
        this.hashOperations.delete("EMPLOYEE",id);
    }
}
