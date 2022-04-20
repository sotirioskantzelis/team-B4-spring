package com.example.teamb4spring.dto;

import com.example.teamb4spring.enums.PositionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContentPositionDTO {

  String contentName;

  String description;

  PositionType positionType;

}
