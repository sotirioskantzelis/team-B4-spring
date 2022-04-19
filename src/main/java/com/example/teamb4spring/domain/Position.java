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

  @ManyToOne()
  Movie movie;

  @ManyToOne()
  TvShow tvShow;

  private PositionType positionType;

  @ManyToOne
  private Person person;

  String description;
}
