/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leantech.employee.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leantech.employee.model.Position;

/**
 *
 * @author miguelangel
 */
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    
    @Query(value = "select p.id as position_id, p.name as position_name,"
    	+ " e.id as employee_id, e.salary as employee_salary, e.person.name as person_name, "
    	+ " e.person.lastName as person_lastname, e.person.address as person_address, "
    	+ " e.person.cellphone as person_cellphone, e.person.cityName as person_city_name "
    	+ " from Position p left outer join Employee e on p.id = e.position.id "
    	+ " order by p.name asc, e.salary desc")
    List<Tuple> findAllPositionsAndEmployees();

}
