package com.raquelheredia.api.netflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raquelheredia.api.netflix.model.Chapters;
import com.raquelheredia.api.netflix.model.Seasons;

@Repository
public interface SeasonRepository extends JpaRepository <Seasons, Long> {

	List <Seasons> findByTvShowsId (Long shows_id);
	
	Seasons findByIdAndTvShowsId (Long id, Long showsId);
}

