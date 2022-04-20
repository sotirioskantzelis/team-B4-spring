package com.example.teamb4spring.controller;

import com.example.teamb4spring.base.BaseComponent;
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
public class PersonController extends BaseComponent {

  private final PersonService personService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> findAll() {
    logger.info("trying to fetch all people");
    return ResponseEntity.ok(PersonMapper.mapToPersonDTOs(personService.findAll()));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
    logger.info("trying to fetch people by {}", id);
    return ResponseEntity.ok(PersonMapper.mapToPersonDTO(personService.get(id)));
  }

  @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> findByName(@PathVariable(name="name") String name) {
    return ResponseEntity.ok(PersonMapper.mapToPersonDTOs(personService.findByName(name)));
 }
}
