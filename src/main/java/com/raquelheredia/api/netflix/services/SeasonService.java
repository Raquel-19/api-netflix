package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface SeasonService {

	List<SeasonRest> findSeasonByShow(Long showId) throws NetflixExceptions;

	SeasonRest findSeasonOfASpecificShow(Long seasonId, Long showId) throws NetflixExceptions;

}
