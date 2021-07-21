/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leantech.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantech.employee.model.Employee;
import com.leantech.employee.model.Position;
import com.leantech.employee.repository.EmployeeRepository;

/**
 *
 * @author miguelangel
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionService positionService;

    @Override
    public List<Employee> findByNameAndPosition(String name, String position) {
	return employeeRepository.findByNameAndPosition(name, position);
    }

    @Override
    public Employee save(Employee employee) {
	Position position = positionService.findById(employee.getPosition().getId())
		.orElseGet(() -> positionService.save(employee.getPosition()));

	employee.setPosition(position);
	return employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
	employeeRepository.findById(employee.getId()).orElseThrow();

	Position position = positionService.findById(employee.getPosition().getId())
		.orElseGet(() -> positionService.save(employee.getPosition()));

	employee.setPosition(position);
	employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
	employeeRepository.deleteById(id);
    }

}
