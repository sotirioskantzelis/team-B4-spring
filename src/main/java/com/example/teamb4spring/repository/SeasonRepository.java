package com.example.teamb4spring.repository;

import com.example.teamb4spring.domain.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season,Long> {

}
