package com.example.teamb4spring.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseModel {

  @ManyToOne()
  Movie movie;

  @ManyToOne()
  TvShow tvShow;

  @ManyToOne()
  private Actor actor;

  String description;
}
