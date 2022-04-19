package com.example.teamb4spring.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Episode extends BaseModel{

  String title;

  String description;

  @ManyToOne
  Season season;

}
