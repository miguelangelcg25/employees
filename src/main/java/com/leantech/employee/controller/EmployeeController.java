/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leantech.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leantech.employee.model.Employee;
import com.leantech.employee.service.EmployeeService;

/**
 *
 * @author miguelangel
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findEmployees(@RequestParam(value = "name", required = false) String name,
	    @RequestParam(value = "position", required = false) String position) {
	return employeeService.findByNameAndPosition(name, position);
    }

    @PostMapping
    public void saveEmployee(@RequestBody Employee employee) {
	employeeService.save(employee);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
	employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
	employeeService.delete(id);
    }

}
