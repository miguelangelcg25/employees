/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leantech.employee.service;

import com.leantech.employee.model.Employee;
import java.util.List;

/**
 *
 * @author miguelangel
 */
public interface EmployeeService {

    List<Employee> findByNameAndPosition(String name, String position);

    Employee save(Employee employee);

    void update(Employee employee);

    void delete(Long id);

}
