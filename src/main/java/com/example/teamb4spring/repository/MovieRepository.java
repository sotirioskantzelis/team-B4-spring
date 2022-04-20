package com.example.teamb4spring.repository;

import com.example.teamb4spring.domain.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{

  List<Movie> findByTitleContainingIgnoreCase(String name);
}
