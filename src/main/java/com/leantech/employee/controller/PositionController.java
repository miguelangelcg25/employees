package com.leantech.employee.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leantech.employee.dto.PositionDTO;
import com.leantech.employee.service.PositionService;

@RestController
@RequestMapping("/positions")
public class PositionController {
    
    @Autowired
    private PositionService positionService;
    
    @GetMapping
    public Set<PositionDTO> findAllByPositionAndEmployee() {
	return positionService.findAllPositionsAndEmployees();
    }

}
