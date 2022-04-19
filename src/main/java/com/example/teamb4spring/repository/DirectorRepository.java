package com.example.teamb4spring.repository;

import com.example.teamb4spring.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {
}
