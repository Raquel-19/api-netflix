package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface SeasonService {

	List<SeasonRest> findSeasonByShow(Long showsId) throws NetflixExceptions;

	SeasonRest findSeasonOfASpecificShow(Long seasonsId, Long showsId) throws NetflixExceptions;

}
