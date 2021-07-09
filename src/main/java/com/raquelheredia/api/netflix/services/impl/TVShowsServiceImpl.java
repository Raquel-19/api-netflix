package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.TVShowsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.exceptions.NotFoundException;
import com.raquelheredia.api.netflix.model.TVShows;
import com.raquelheredia.api.netflix.repository.TVShowsRepository;
import com.raquelheredia.api.netflix.services.TVShowsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TVShowsServiceImpl implements TVShowsService {
	
	private final TVShowsRepository repositoryShows;
	
	private final ModelMapper modelMapper;


	@Override
	public TVShowsRest findById(Long id) throws NetflixExceptions {
		
	TVShows sh = repositoryShows.findById(id).get();
		
		if (sh == null) 
			throw new NotFoundException("SERIE NO ENCONTRADA. POR FAVOR, ESCRIBA OTRO ID.");
		
		return modelMapper.map(sh, TVShowsRest.class);		
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
	public List<TVShowsRest> findByCategoryId (Long categoryId) throws NetflixExceptions{
		
		List<TVShows> sh = repositoryShows.findByCategoryId(categoryId);
		
		if(sh.size() == 0)
			throw new NotFoundException("SERIES NO ENCONTRADAS CON LA CATEGORIA SELECCIONADA.");
		
		return sh.stream()
				.map(show -> modelMapper.map(show, TVShowsRest.class))
				.collect(Collectors.toList());
	}
}
