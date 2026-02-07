package com.example.demo;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);


}
