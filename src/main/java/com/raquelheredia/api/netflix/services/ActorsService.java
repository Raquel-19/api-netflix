package com.raquelheredia.api.netflix.services;

import java.util.List;
import java.util.Optional;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.model.Actors;

public interface ActorsService {

	ActorsRest updateActor(ActorsRest actor);
	ActorsRest createActor(ActorsRest actor);
	ActorsRest findById(Long id) throws Exception;
	List<ActorsRest> findAllActors() throws NetflixExceptions;
	void deleteById(Long id);
	

}
