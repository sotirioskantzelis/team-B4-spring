package com.example.teamb4spring.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Actor extends BaseModel{

  @OneToOne(mappedBy = "actor")
  Person person;

  @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  Set<Role> roles;

}
