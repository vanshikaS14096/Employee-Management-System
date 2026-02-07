package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class service {
    @Autowired
    private repository rep;
    public List<Employee> getEmployee(){
        return rep.findAll();
    }
    public Employee addEmployee(Employee employee){
        return rep.save(employee);
    }
    public void deleteEmployee(Long id){
        rep.deleteById(id);
    }
    public Employee updateEmployee(Long id, Employee employee){
        employee.setId(id);
        return rep.save(employee);
    }
    public Employee getEmployeeById(Long id){
        return rep.findById(id).orElse(null);
    }
    public Page<Employee> getPage(Pageable pageable){
        return rep.findAll(pageable);
    }
    public List<Employee> findbyname(String name){
        return rep.findByName(name);
    }




}
