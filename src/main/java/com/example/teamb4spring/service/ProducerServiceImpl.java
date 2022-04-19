package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Producer;
import com.example.teamb4spring.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProducerServiceImpl extends BaseServiceImpl<Producer> implements ProducerService {

  private final ProducerRepository producerRepository;

  @Override
  public JpaRepository<Producer, Long> getRepository() {
    return producerRepository;
  }


}
