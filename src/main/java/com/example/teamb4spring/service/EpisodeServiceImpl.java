package com.example.teamb4spring.service;

import com.example.teamb4spring.domain.Episode;
import com.example.teamb4spring.domain.Movie;
import com.example.teamb4spring.repository.EpisodeRepository;
import com.example.teamb4spring.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EpisodeServiceImpl extends BaseServiceImpl<Episode> implements EpisodeService {
	private final EpisodeRepository episodeRepository;

	@Override
	public JpaRepository<Episode, Long> getRepository() {
		return episodeRepository;
	}


}
