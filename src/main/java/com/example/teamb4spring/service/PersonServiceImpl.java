package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Person;
import com.example.teamb4spring.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {

  private final PersonRepository personRepository;

  @Override
  public JpaRepository<Person, Long> getRepository() {
    return personRepository;
  }


}
