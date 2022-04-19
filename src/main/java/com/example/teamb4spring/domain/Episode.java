package com.example.teamb4spring.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Episode extends BaseModel{

  String title;

  String description;

  @ManyToOne
  Season season;

}
