package com.example.teamb4spring.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class Position extends BaseModel {

  @ManyToOne
  @JoinColumn(name = "movie_id")
  Movie movie;

  @ManyToOne
  @JoinColumn(name = "tv_show_id")
  TvShow tvShow;

  private PositionType positionType;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person person;

  String description;
}
