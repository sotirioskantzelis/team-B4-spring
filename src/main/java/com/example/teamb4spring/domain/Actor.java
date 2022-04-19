package com.example.teamb4spring.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Actor extends BaseModel{

  @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  Set<Role> roles;

}
