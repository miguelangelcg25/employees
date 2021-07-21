package com.leantech.employee.dto;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PositionDTO {
    
    public PositionDTO(Long id, String name, Comparator<EmployeeDTO> empComparator) {
	this.id = id;
	this.name = name;
	this.employees = new TreeSet<>(empComparator);
    }

    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private Set<EmployeeDTO> employees;

}
