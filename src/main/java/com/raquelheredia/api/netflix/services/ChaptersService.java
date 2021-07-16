package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.ChaptersRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface ChaptersService {

	List<ChaptersRest> findChaptersOfSpecificSeasonAndShow(Long seasonId, Long showId) throws NetflixExceptions;

	ChaptersRest findSeasonOfSeasonAndShowNumber(Long chapterId, Long seasonId, Long showId) throws NetflixExceptions;

	ChaptersRest updateChapter(Long chapterId, String newName) throws NetflixExceptions;

}
