package com.leantech.employee.service;

import java.util.Optional;
import java.util.Set;

import com.leantech.employee.dto.PositionDTO;
import com.leantech.employee.model.Position;

public interface PositionService {

    Position save(Position position);

    void update(Position position);

    void delete(Long id);

    Optional<Position> findById(Long id);

    Set<PositionDTO> findAllPositionsAndEmployees();

}
