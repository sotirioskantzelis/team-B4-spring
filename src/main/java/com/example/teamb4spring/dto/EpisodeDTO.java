package com.example.teamb4spring.dto;

import com.example.teamb4spring.domain.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class EpisodeDTO extends BaseModel {

  private String title;

  private String description;

  private int seasonNumber;

}