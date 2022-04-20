package com.example.teamb4spring.mappers;

import com.example.teamb4spring.domain.Episode;
import com.example.teamb4spring.domain.Movie;
import com.example.teamb4spring.domain.Position;
import com.example.teamb4spring.domain.TvShow;
import com.example.teamb4spring.domain.ViewContent;
import com.example.teamb4spring.dto.ContentDTO;
import com.example.teamb4spring.dto.CrewDTO;
import com.example.teamb4spring.dto.EpisodeDTO;
import com.example.teamb4spring.dto.MovieDTO;
import com.example.teamb4spring.dto.TvShowDTO;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;


@UtilityClass
public class MovieMapper {

  public List<MovieDTO> mapToMovieDTOs(List<Movie> movies){
    return movies.stream().map(MovieMapper::mapToMovieDTO).collect(Collectors.toList());
  }

  public List<TvShowDTO> mapToShowDTOs(List<TvShow> tvShows){
    return tvShows.stream().map(MovieMapper::mapToShowDTO).collect(Collectors.toList());
  }

  public void mapToDTO(ViewContent viewContent, ContentDTO contentDTO){
    contentDTO.setTitle(viewContent.getTitle());
    contentDTO.setDescription(viewContent.getDescription());
    contentDTO.setReleaseYear(viewContent.getReleaseYear());
  }

  public MovieDTO mapToMovieDTO(Movie movie){
    MovieDTO movieDTO = new MovieDTO();
    mapToDTO(movie,movieDTO);
    movieDTO.setDuration(movie.getDuration());
    movieDTO.setCrew(mapCrew(movie.getPositionList()));
    return movieDTO;
  }

  public TvShowDTO mapToShowDTO(TvShow tvShow){
    TvShowDTO tvShowDTO = new TvShowDTO();
    mapToDTO(tvShow,tvShowDTO);
    tvShowDTO.setCrew(mapCrew(tvShow.getPositionList()));
    tvShowDTO.setEpisodeDTOSet(mapEpisode(tvShow.getEpisodes()));
    return tvShowDTO;
  }

  public Set<EpisodeDTO> mapEpisode(Set<Episode> episodes){
    return episodes.stream().map(episode->new EpisodeDTO(episode.getTitle(),episode.getDescription(),episode.getSeasonNumber())).collect(
        Collectors.toSet());
  }

  public Set<CrewDTO> mapCrew(Set<Position> positionSet){
      return positionSet.stream().map(set->new CrewDTO(set.getPerson().getFirstName(),set.getPerson().getLastName(),set.getPerson().getDateOfBirth(),set.getDescription(),set.getPositionType())).collect(
          Collectors.toSet());
  }

}
