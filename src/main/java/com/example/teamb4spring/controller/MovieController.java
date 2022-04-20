package com.example.teamb4spring.controller;

import com.example.teamb4spring.mappers.MovieMapper;
import com.example.teamb4spring.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("movies")
public class MovieController {

  private final MovieService movieService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getProducts() {
    return ResponseEntity.ok(MovieMapper.mapToMovieDTOs(movieService.findAll()));
  }

}