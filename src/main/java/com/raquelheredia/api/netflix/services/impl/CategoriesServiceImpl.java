package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.dto.CategoriesRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.repository.ActorsRepository;
import com.raquelheredia.api.netflix.repository.CategoriesRepository;
import com.raquelheredia.api.netflix.services.CategoriesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
	
	private final CategoriesRepository repositoryCategories;
	
	private final ModelMapper modelMapper;

	@Override
	public List<CategoriesRest> findAllCategories() throws NetflixExceptions  {
		return repositoryCategories.findAll().stream()
				.map(category -> modelMapper.map(category, CategoriesRest.class))
				.collect(Collectors.toList());
		
	}

	@Override
	public CategoriesRest findById(Long id) throws Exception {
		return repositoryCategories.findById(id).map(category -> modelMapper.map(category, CategoriesRest.class))
				.orElseThrow(() -> new Exception("NO EXISTE EL ID"));
	}

}
