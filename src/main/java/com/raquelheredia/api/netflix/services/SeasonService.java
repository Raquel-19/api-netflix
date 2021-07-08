package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.dto.TVShowsRest;

public interface SeasonService {

	List<SeasonRest> findSeasonByShow(Long shows_id);

	SeasonRest findSeasonOfASpecificShow(Long showsId, Long seasonsId);
	
	
	

}
