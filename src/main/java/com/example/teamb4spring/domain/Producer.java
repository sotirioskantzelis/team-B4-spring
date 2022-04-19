package com.example.teamb4spring.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Producer extends Employee {

  @ManyToMany(mappedBy = "producers")
  private Set<Movie> movies = new HashSet<>();

}
