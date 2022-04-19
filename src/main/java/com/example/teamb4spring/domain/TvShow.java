package com.example.teamb4spring.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
public class TvShow extends ViewContent {

  int numberOfSeasons;

  @OneToMany(mappedBy = "tvShow", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  Set<Season> seasons = new HashSet<>();

  @OneToMany(mappedBy = "tvShow", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  Set<Role> cast = new HashSet<>();

}
