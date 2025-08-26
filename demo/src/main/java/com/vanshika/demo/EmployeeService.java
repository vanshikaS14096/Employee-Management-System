package com.vanshika.demo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@AllArgsConstructor

public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;


    public List<Employee> GetEmployee(){
        return repo.findAll();
    }
    public Employee GetEmployeeById(int id) {
        return repo.findById(id).get();
    }

    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
    public List<Employee> searchEmployees(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

}
