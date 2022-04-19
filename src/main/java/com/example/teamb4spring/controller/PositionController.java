package com.example.teamb4spring.controller;

import com.example.teamb4spring.domain.Position;
import com.example.teamb4spring.service.PositionService;
import com.example.teamb4spring.transfer.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("position")
public class PositionController {

  private final PositionService positionService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ApiResponse<List<Position>>> getProducts() {
    return new ResponseEntity<>(ApiResponse.<List<Position>>builder().data(positionService.findAll()).build(), HttpStatus.OK);
  }

}