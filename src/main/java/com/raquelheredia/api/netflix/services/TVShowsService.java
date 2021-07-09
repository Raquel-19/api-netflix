package com.raquelheredia.api.netflix.services;

import java.util.List;
import java.util.Optional;

import com.raquelheredia.api.netflix.dto.TVShowsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface TVShowsService {
	
	TVShowsRest findById(Long id) throws NetflixExceptions;
	TVShowsRest updateShow(TVShowsRest shows);
	List<TVShowsRest> findShowsAndChaptersOfSpecificActor(Long actor_id);
	List<TVShowsRest> findByCategoryId(Long categoryId) throws NetflixExceptions;
	
	
}
