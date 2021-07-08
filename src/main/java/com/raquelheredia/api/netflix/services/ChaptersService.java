package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.ChaptersRest;

public interface ChaptersService {

	ChaptersRest updateChapter(ChaptersRest chapter);

	List<ChaptersRest> findChaptersOfSpecificSeasonAndShow(Long season_id, Long show_id);

	ChaptersRest findSeasonOfSeasonAndShowNumber(Long seasonsId, Long id);

}
