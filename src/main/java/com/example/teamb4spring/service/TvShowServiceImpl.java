package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.TvShow;
import com.example.teamb4spring.repository.TvShowRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TvShowServiceImpl extends BaseServiceImpl<TvShow> implements TvShowService {

  private final TvShowRepository tvShowRepository;

  @Override
  public JpaRepository<TvShow, Long> getRepository() {
    return tvShowRepository;
  }


  @Override
  public List<TvShow> findByName(String name) {
    return tvShowRepository.findByTitleContainingIgnoreCase(name);
  }
}
