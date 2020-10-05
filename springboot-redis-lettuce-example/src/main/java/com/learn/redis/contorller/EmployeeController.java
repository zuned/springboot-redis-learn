package com.learn.redis.contorller;

import com.learn.redis.model.Employee;
import com.learn.redis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEMployee(@RequestBody Employee employee){
        this.employeeService.saveEmployee(employee);
        return employee;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return this.employeeService.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable("id") Long id){
        return this.employeeService.findById(id);
    }

    @PutMapping("/employees")
    public void update(@RequestBody Employee employee){
        this.employeeService.update(employee);

    }
    @DeleteMapping("/employees/{id}")
    public  void delete(@PathVariable("id") Long id){
        this.employeeService.delete(id);
    }

}
