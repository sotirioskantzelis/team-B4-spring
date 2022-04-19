package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Position;
import com.example.teamb4spring.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PositionServiceImpl extends BaseServiceImpl<Position> implements PositionService {

  private final PositionRepository positionRepository;

  @Override
  public JpaRepository<Position, Long> getRepository() {
    return positionRepository;
  }

  private final PositionService positionService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Position>> getProducts() {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping (params = {"tvShow"})
  public ResponseEntity<List<Position>>findByTvShow() {
    return new ResponseEntity<>( HttpStatus.OK);
  }

  @GetMapping (params = {"tvShow/{name}"})
  public ResponseEntity<List<Position>>findTvShowById(@PathVariable(name = "name") Long tvShowName) {
    return ResponseEntity.ok(
            ApiResponse.<List<Position>>builder().data((List<Position>) positionService.findByTvShowId(tvShowName)).build());
  }

  @GetMapping (params = {"person"})
  public ResponseEntity<List<Position>>findByperson() {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping (params = {"person/{name}"})
  public ResponseEntity<ApiResponse<List<Position>>>findPersonById(@PathVariable(name = "name") Long personName) {
    return ResponseEntity.ok(
            ApiResponse.<List<Position>>builder().data((List<Position>) positionService.findByPersonId(personId)).build());
  }

}
