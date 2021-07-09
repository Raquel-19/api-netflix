package com.raquelheredia.api.netflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.model.Chapters;
import com.raquelheredia.api.netflix.model.Seasons;

@Repository
public interface SeasonRepository extends JpaRepository <Seasons, Long> {

	List <Seasons> findByTvShowsId (Long showsId) throws NetflixExceptions;
	
	Seasons findByIdAndTvShowsId (Long id, Long showsId) throws NetflixExceptions;
}

