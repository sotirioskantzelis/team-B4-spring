package com.example.teamb4spring.domain;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@MappedSuperclass
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseModel {

  String firstName;

  String lastName;

  Date dateOfBirth;

}
