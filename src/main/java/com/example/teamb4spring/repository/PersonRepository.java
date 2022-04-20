package com.example.teamb4spring.repository;

import com.example.teamb4spring.domain.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends JpaRepository<Person,Long> {

  List<Person> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String name1, String name2);

}
