package com.example.teamb4spring.dto;

import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TvShowDTO extends ContentDTO{

  Set<EpisodeDTO> episodeDTOSet;
}
