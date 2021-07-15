package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.dto.ActorsRestWithTVShows;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.model.Actors;

public interface ActorsService {

	ActorsRest updateActor(Long actorId, String newName, String newLastName) throws NetflixExceptions;

	ActorsRest createActor(Actors actor) throws NetflixExceptions;

	ActorsRest findById(Long actorId) throws NetflixExceptions;

	List<ActorsRest> findAllActors() throws NetflixExceptions;

	void deleteActor(Long actorId) throws NetflixExceptions;

	ActorsRestWithTVShows findShowsAndChaptersOfSpecificActor(Long actorsId) throws NetflixExceptions;

}
