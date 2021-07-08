package com.raquelheredia.api.netflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.model.Chapters;

@Repository
public interface ChaptersRepository extends JpaRepository <Chapters, Long>{
	
	List <Chapters> findBySeasonsIdAndSeasonsTvShowsId(Long season_id, Long show_id);
	
	Chapters findByIdAndSeasonsId (Long seasonsId, Long id);
}
