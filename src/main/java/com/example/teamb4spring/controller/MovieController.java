package com.example.teamb4spring.controller;

import com.example.teamb4spring.base.BaseComponent;
import com.example.teamb4spring.mappers.ContentMapper;
import com.example.teamb4spring.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("movies")
public class MovieController extends BaseComponent {

  private final MovieService movieService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> findAll() {
    logger.info("trying to fetch all movies");
    return ResponseEntity.ok(ContentMapper.mapToMovieDTOs(movieService.findAll()));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
    logger.info("trying to fetch movies by {}", id);
    return ResponseEntity.ok(ContentMapper.mapToMovieDTO(movieService.get(id)));
  }

  @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> findByName(@PathVariable(name="name") String name) {
    return ResponseEntity.ok(ContentMapper.mapToMovieDTOs(movieService.findByName(name)));
  }

}