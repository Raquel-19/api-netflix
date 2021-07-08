package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.dto.TVShowsRest;
import com.raquelheredia.api.netflix.repository.TVShowsRepository;
import com.raquelheredia.api.netflix.services.TVShowsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TVShowsServiceImpl implements TVShowsService {
	
	private final TVShowsRepository repositoryShows;
	
	private final ModelMapper modelMapper;


	@Override
	public TVShowsRest findById(Long id) throws Exception {
		return repositoryShows.findById(id).map(shows -> modelMapper.map(shows, TVShowsRest.class))
				.orElseThrow(() -> new Exception("NO EXISTE EL ID"));
	}

	@Override
	public TVShowsRest updateShow(TVShowsRest shows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TVShowsRest> findShowsAndChaptersOfSpecificActor(Long actor_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TVShowsRest> findByCategoryId (Long categoryId) {
		return repositoryShows.findByCategoryId(categoryId).stream()
				.map(show -> modelMapper.map(show, TVShowsRest.class))
				.collect(Collectors.toList());
	}
}
