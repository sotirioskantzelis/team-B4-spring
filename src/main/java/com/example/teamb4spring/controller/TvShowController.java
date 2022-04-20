package com.example.teamb4spring.controller;

import com.example.teamb4spring.mappers.ContentMapper;
import com.example.teamb4spring.service.TvShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tvshows")
@RequiredArgsConstructor
public class TvShowController {

  private final TvShowService tvShowService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getTvShows() {
    return ResponseEntity.ok(ContentMapper.mapToShowDTOs(tvShowService.findAll()));
  }

}
