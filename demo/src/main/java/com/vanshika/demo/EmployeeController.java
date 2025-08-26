package com.vanshika.demo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/employee")
    public List<Employee> GetEmployee() {
        return service.GetEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee GetEmployeeById(@PathVariable int id) {
        return service.GetEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @DeleteMapping("/employeeid/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee deleted with id: " + id;
    }

    @GetMapping("/employees/search")
    public List<Employee> searchEmployees(@RequestParam String name) {
        return service.searchEmployees(name);
    }
}




