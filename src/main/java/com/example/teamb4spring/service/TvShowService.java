package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.TvShow;
import java.util.List;

public interface TvShowService extends BaseService<TvShow,Long> {

  List<TvShow> findByName(String name);
}
