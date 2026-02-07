package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;
@CrossOrigin(origins="http://127.0.0.1:5500")
@RestController
public class controller {
    @Autowired
    private service serv;
    @GetMapping("/getEmp")

    public List<Employee> getEmployee(){
        return serv.getEmployee();
    }
    @PostMapping("/addEmp")
    public Employee createEmployee(@RequestBody Employee employee){
        return serv.addEmployee(employee);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        serv.deleteEmployee(id);

    }
    @PutMapping("/updateEmp/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee){
        return serv.updateEmployee(id, employee);
    }
    @GetMapping("get/emplById/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return serv.getEmployeeById(id);
    }
    @GetMapping("/employees/page")
    public Page<Employee> getPage(Pageable pageable){
        return serv.getPage(pageable);
    }

}
