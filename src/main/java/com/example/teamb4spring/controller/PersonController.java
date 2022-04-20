package com.example.teamb4spring.controller;

import com.example.teamb4spring.mappers.PersonMapper;
import com.example.teamb4spring.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("people")
public class PersonController {

  private final PersonService personService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> getMovies() {
    return ResponseEntity.ok(PersonMapper.mapToPersonDTOs(personService.findAll()));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> findMovieById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(PersonMapper.mapToPersonDTO(personService.get(id)));
  }

  //todo why @Pathvariable second time doesn't work
//  @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//  @ResponseBody
//  public ResponseEntity<Object> getMoviesByName(@PathVariable(name="name") String name) {
//    return ResponseEntity.ok(PersonMapper.mapToPersonDTOs(personService.findPersonByFirstNameOrLastNameContainingIgnoreCase(name, name)));
//  }
}
