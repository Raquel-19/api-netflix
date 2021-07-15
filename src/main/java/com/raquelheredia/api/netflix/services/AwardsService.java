package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.AwardsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface AwardsService {

	List<AwardsRest> findAllAwards() throws NetflixExceptions;

}
