package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.repository.ActorsRepository;
import com.raquelheredia.api.netflix.services.ActorsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActorsServiceImpl implements ActorsService{
	
	private final ActorsRepository repositoryActors;
	
	private final ModelMapper modelMapper;


	@Override
	public ActorsRest updateActor(ActorsRest actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActorsRest createActor(ActorsRest actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActorsRest findById(Long id) throws Exception {
		return repositoryActors.findById(id).map(actor -> modelMapper.map(actor, ActorsRest.class))
				.orElseThrow(() -> new Exception("NO EXISTE EL ID"));
//		return modelMapper.map(repositoryActors.findById(id).get(), ActorsRest.class);
	}

	@Override
	public List<ActorsRest> findAllActors() throws NetflixExceptions {
		return repositoryActors.findAll().stream()
				.map(actor -> modelMapper.map(actor, ActorsRest.class))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
