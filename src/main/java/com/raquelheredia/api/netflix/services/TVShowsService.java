package com.raquelheredia.api.netflix.services;

import java.util.List;
import java.util.Optional;

import com.raquelheredia.api.netflix.dto.TVShowsRest;

public interface TVShowsService {
	
	TVShowsRest findById(Long id) throws Exception;
	TVShowsRest updateShow(TVShowsRest shows);
	List<TVShowsRest> findShowsAndChaptersOfSpecificActor(Long actor_id);
	
	
	
	List<TVShowsRest> findByCategoryId(Long category_id);
	
	
	
	

}
