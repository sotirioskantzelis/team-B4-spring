package com.example.teamb4spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class EpisodeDTO {

  private String title;

  private String description;

  private int seasonNumber;

}