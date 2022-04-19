package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Actor;
import com.example.teamb4spring.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ActorServiceImpl extends BaseServiceImpl<Actor> implements ActorService {

  private final ActorRepository actorRepository;

  @Override
  public JpaRepository<Actor, Long> getRepository() {
    return actorRepository;
  }


}
