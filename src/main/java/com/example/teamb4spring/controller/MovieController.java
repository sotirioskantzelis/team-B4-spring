package com.example.teamb4spring.controller;

import com.example.teamb4spring.mappers.ContentMapper;
import com.example.teamb4spring.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("movies")
@ControllerAdvice
public class MovieController {

  private final MovieService movieService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getMovies() {
    return ResponseEntity.ok(ContentMapper.mapToMovieDTOs(movieService.findAll()));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> findMovieById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(ContentMapper.mapToMovieDTO(movieService.get(id)));
  }

}