package com.example.teamb4spring.mappers;

import com.example.teamb4spring.domain.Person;
import com.example.teamb4spring.domain.Position;
import com.example.teamb4spring.dto.PersonDTO;
import com.example.teamb4spring.dto.ContentPositionDTO;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonMapper {

  public List<PersonDTO> mapToPersonDTO(List<Person> people) {
    return people.stream().map(PersonMapper::mapToPersonDTO).collect(Collectors.toList());
  }


  private PersonDTO mapToPersonDTO(Person person) {
    PersonDTO personDTO = new PersonDTO();
    personDTO.setFirstName(person.getFirstName());
    personDTO.setLastName(person.getLastName());
    personDTO.setDateOfBirth(person.getDateOfBirth());
    personDTO.setContentPositions(mapToContentPositions(person.getPositionList()));
    return personDTO;
  }

  private Set<ContentPositionDTO> mapToContentPositions(Set<Position> positionList) {
    return positionList.stream().map(PersonMapper::mapToContentPosition)
        .collect(Collectors.toSet());
  }

  private static ContentPositionDTO mapToContentPosition(Position position) {
    ContentPositionDTO contentPosition = new ContentPositionDTO();
    contentPosition.setContentName(
        Objects.nonNull(position.getMovie()) ? position.getMovie().getTitle()
            : position.getTvShow().getTitle());
    contentPosition.setDescription(position.getDescription());
    contentPosition.setPositionType(position.getPositionType());
    return contentPosition;
  }

}
