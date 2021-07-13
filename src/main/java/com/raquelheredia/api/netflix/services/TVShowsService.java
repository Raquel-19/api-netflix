package com.raquelheredia.api.netflix.services;

import java.util.List;
import java.util.Optional;

import com.raquelheredia.api.netflix.dto.CategoriesRest;
import com.raquelheredia.api.netflix.dto.TVShowsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface TVShowsService {
	
	TVShowsRest findById(Long id) throws NetflixExceptions;
	TVShowsRest updateShow(Long nameId, String newName) throws NetflixExceptions;
	List<TVShowsRest> findByCategoryId(Long categoryId) throws NetflixExceptions;
	TVShowsRest addCategories(Long categoryId, Long showsId) throws NetflixExceptions;
	public void deleteShow(Long showsId) throws NetflixExceptions;
	
	
}
