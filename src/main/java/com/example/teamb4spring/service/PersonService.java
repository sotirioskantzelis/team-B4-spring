package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Person;
import java.util.List;

public interface PersonService extends BaseService<Person, Long> {

  List<Person> findByName(String name);


}
