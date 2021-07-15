package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.CategoriesRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.exceptions.NotFoundException;
import com.raquelheredia.api.netflix.model.Categories;
import com.raquelheredia.api.netflix.repository.CategoriesRepository;
import com.raquelheredia.api.netflix.services.CategoriesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

	private final CategoriesRepository repositoryCategories;

	private final ModelMapper modelMapper;

	@Override
	public List<CategoriesRest> findAllCategories() throws NetflixExceptions {

		List<Categories> ca = repositoryCategories.findAll();

		if (ca.size() == 0)
			throw new NotFoundException("CATEGORIAS NO ENCONTRADAS.");

		return ca.stream().map(category -> modelMapper.map(category, CategoriesRest.class))
				.collect(Collectors.toList());
	}

	@Override
	public CategoriesRest findById(Long categoryId) throws NetflixExceptions {

		Categories ca = repositoryCategories.findById(categoryId)
				.orElseThrow(() -> new NotFoundException("CATEGORIA NO ENCONTRADA. POR FAVOR, ESCRIBA OTRO ID"));

		return modelMapper.map(ca, CategoriesRest.class);
	}
}
