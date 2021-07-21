package com.leantech.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantech.employee.dto.EmployeeDTO;
import com.leantech.employee.dto.PositionDTO;
import com.leantech.employee.model.Position;
import com.leantech.employee.repository.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    private static final Comparator<PositionDTO> ORDER_BY_POSISTION_NAME = (pos1, pos2) -> {
	return pos1.getName().compareToIgnoreCase(pos2.getName());
    };
    
    private static final Comparator<EmployeeDTO> ORDER_BY_EMPLOYEE_SALARY = (e1, e2) -> {
	return e1.getSalary() > e2.getSalary() ? -1 : 1;
    };

    @Override
    public Position save(Position position) {
	return positionRepository.save(position);
    }

    @Override
    public void update(Position position) {
	positionRepository.findById(position.getId()).orElseThrow();
	positionRepository.save(position);
    }

    @Override
    public void delete(Long id) {
	positionRepository.findById(id).orElseThrow();
	positionRepository.deleteById(id);
    }

    @Override
    public Optional<Position> findById(Long id) {
	return positionRepository.findById(id);
    }

    @Override
    public Set<PositionDTO> findAllPositionsAndEmployees() {
	List<Tuple> results = positionRepository.findAllPositionsAndEmployees();
	Set<PositionDTO> positions = new TreeSet<>(ORDER_BY_POSISTION_NAME);
	Long id = null;
	PositionDTO posDTO = null;

	for (Tuple t : results) {
	    if (!Objects.equals(id, t.get("position_id"))) {
		posDTO = new PositionDTO((Long) t.get("position_id"), (String) t.get("position_name"), ORDER_BY_EMPLOYEE_SALARY);
		positions.add(posDTO);
		id = (Long) t.get("position_id");
	    }
	    EmployeeDTO empDTO = new EmployeeDTO();
	    empDTO.setId((Long) t.get("employee_id"));
	    empDTO.setSalary((Double) t.get("employee_salary"));
	    empDTO.setName((String) t.get("person_name"));
	    empDTO.setLastName((String) t.get("person_lastname"));
	    empDTO.setAddress((String) t.get("person_address"));
	    empDTO.setCellphone((String) t.get("person_cellphone"));
	    empDTO.setCityName((String) t.get("person_city_name"));
	    posDTO.getEmployees().add(empDTO);
	}
	
	return positions;
    }

}
