package com.example.teamb4spring.repository;

import com.example.teamb4spring.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Long> {
}
