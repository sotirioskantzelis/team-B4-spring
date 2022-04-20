package com.example.teamb4spring.dto;

import com.example.teamb4spring.domain.PositionType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CrewDTO {

  String firstName;
  String lastName;
  Date dateOfBirth;
  String description;
  PositionType positionType;
}
