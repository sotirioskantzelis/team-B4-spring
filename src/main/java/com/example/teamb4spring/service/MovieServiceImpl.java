package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Movie;
import com.example.teamb4spring.domain.Person;
import com.example.teamb4spring.repository.MovieRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
	private final MovieRepository movieRepository;

	@Override
	public JpaRepository<Movie, Long> getRepository() {
		return movieRepository;
	}


	@Override
	public List<Movie> findByName(String name) {
		return movieRepository.findByTitleContainingIgnoreCase(name);
	}
}
