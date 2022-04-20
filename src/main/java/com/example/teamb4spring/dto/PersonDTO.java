package com.example.teamb4spring.dto;

import java.util.Date;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {

  String firstName;

  String lastName;

  Date dateOfBirth;

  Set<ContentPositionDTO> contentPositions;

}
