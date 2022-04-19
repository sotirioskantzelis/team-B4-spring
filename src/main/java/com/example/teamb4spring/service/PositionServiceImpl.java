package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Position;
import com.example.teamb4spring.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PositionServiceImpl extends BaseServiceImpl<Position> implements PositionService {

  private final PositionRepository positionRepository;

  @Override
  public JpaRepository<Position, Long> getRepository() {
    return positionRepository;
  }


}
