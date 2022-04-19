package com.example.teamb4spring.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class Movie extends ViewContent{

  int duration;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "movie_production",
      joinColumns = { @JoinColumn(name = "movie") },
      inverseJoinColumns = { @JoinColumn(name = "producer")})
  Set<Producer> producers = new HashSet<>();

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "movie_direction",
      joinColumns = { @JoinColumn(name = "movie") },
      inverseJoinColumns = { @JoinColumn(name = "director")})
  Set<Movie> directors = new HashSet<>();

  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  Set<Role> cast = new HashSet<>();


}
