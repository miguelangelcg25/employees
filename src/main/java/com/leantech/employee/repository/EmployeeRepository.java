/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leantech.employee.repository;

import com.leantech.employee.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author miguelangel
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "from Employee e where "
	    + "(:name is null or UPPER(e.person.name) like UPPER('%'||:name||'%') or UPPER(e.person.lastName) like UPPER('%'||:name||'%')) "
	    + "and (:position is null or UPPER(e.position.name) like UPPER('%'||:position||'%'))")
    List<Employee> findByNameAndPosition(String name, String position);

}
