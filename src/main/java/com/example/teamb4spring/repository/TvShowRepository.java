package com.example.teamb4spring.repository;

import com.example.teamb4spring.domain.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow,Long> {
}
