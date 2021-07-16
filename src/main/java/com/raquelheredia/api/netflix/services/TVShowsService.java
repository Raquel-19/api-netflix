package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.TVShowsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface TVShowsService {

	TVShowsRest findById(Long showId) throws NetflixExceptions;

	TVShowsRest updateShow(Long showId, String newName) throws NetflixExceptions;

	List<TVShowsRest> findByCategoryId(Long categoryId) throws NetflixExceptions;

	TVShowsRest addCategories(Long categoryId, Long showId) throws NetflixExceptions;

	public void deleteShow(Long showId) throws NetflixExceptions;

}
