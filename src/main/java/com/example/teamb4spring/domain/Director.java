package com.example.teamb4spring.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Director extends BaseModel {

  @OneToOne(mappedBy = "director")
  Person person;

  @ManyToMany(mappedBy = "directors")
  private Set<Movie> movies = new HashSet<>();
}
