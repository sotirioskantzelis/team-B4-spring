package com.example.teamb4spring.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class Position extends BaseModel {

  @JoinColumn(name = "movie_id")
  @ManyToOne(fetch = FetchType.LAZY)
  Movie movie;

  @JoinColumn(name = "tv_show_id")
  @ManyToOne(fetch = FetchType.LAZY)
  TvShow tvShow;

  private PositionType positionType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  private Person person;

  String description;
}
