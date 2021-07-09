package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.ChaptersRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface ChaptersService {

	ChaptersRest updateChapter(ChaptersRest chapter);

	List<ChaptersRest> findChaptersOfSpecificSeasonAndShow(Long seasonsId, Long showsId) throws NetflixExceptions;

	ChaptersRest findSeasonOfSeasonAndShowNumber(Long id, Long SeasonsId, Long showsId) throws NetflixExceptions;
	

}
