package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.dto.AwardsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.repository.ActorsRepository;
import com.raquelheredia.api.netflix.repository.AwardsRepository;
import com.raquelheredia.api.netflix.services.AwardsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AwardsServiceImpl implements AwardsService {
	
	private final AwardsRepository repositoryAwards;
	
	private final ModelMapper modelMapper;

	@Override
	public List<AwardsRest> findAllAwards() throws NetflixExceptions{
			return repositoryAwards.findAll().stream()
					.map(award -> modelMapper.map(award, AwardsRest.class))
					.collect(Collectors.toList());
		}
	}

