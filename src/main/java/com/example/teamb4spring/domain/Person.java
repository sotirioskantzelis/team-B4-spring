package com.example.teamb4spring.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Person extends BaseModel {

  String firstName;

  String lastName;

  Date dateOfBirth;

  @OneToOne
  @JoinColumn(name = "ACTOR_ID") //todo may change ACTOR_ID based on db
  Actor actor;

  @OneToOne
  @JoinColumn(name = "DIRECTOR_ID")
  Director director;

  @OneToOne
  @JoinColumn(name = "PRODUCER_ID")
  Producer producer;

}
