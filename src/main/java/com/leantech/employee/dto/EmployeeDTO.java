package com.leantech.employee.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class EmployeeDTO {

    @EqualsAndHashCode.Include
    private Long id;

    private Double salary;
    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private String cityName;

}
