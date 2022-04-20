package com.example.teamb4spring.service;


import com.example.teamb4spring.domain.Movie;
import java.util.List;

public interface MovieService extends BaseService<Movie,Long> {

  List<Movie> findByName(String name);
}
