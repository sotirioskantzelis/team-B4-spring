package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Position;

public interface PositionService extends BaseService<Position, Long> {

    Position findByTvShow(Long tvShowId);
}
