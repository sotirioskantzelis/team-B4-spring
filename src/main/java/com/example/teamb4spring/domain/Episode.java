package com.example.teamb4spring.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Episode extends BaseModel{

  String title;

  String description;

  @ManyToOne
  @JoinColumn(name = "SEASON_ID")
  Season season;

}
