package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.ChaptersRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface ChaptersService {

	List<ChaptersRest> findChaptersOfSpecificSeasonAndShow(Long seasonsId, Long showsId) throws NetflixExceptions;

	ChaptersRest findSeasonOfSeasonAndShowNumber(Long chaptersId, Long seasonsId, Long showsId) throws NetflixExceptions;

	ChaptersRest updateChapter(Long chaptersId, String newName) throws NetflixExceptions;

}
