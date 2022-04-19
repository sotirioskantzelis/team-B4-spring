package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Director;
import com.example.teamb4spring.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DirectorServiceImpl extends BaseServiceImpl<Director> implements DirectorService {

  private final DirectorRepository directorRepository;

  @Override
  public JpaRepository<Director, Long> getRepository() {
    return directorRepository;
  }


}
