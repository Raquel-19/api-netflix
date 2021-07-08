package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.ChaptersRest;
import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.repository.ChaptersRepository;
import com.raquelheredia.api.netflix.services.ChaptersService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChaptersServiceImpl implements ChaptersService{
	
	private final ChaptersRepository repositoryChapters;
	
	private final ModelMapper modelMapper;
	

	@Override
	public ChaptersRest updateChapter(ChaptersRest chapter) {
		return null;
	}

	@Override
	public List<ChaptersRest> findChaptersOfSpecificSeasonAndShow(Long season_id, Long show_id){
		return repositoryChapters.findBySeasonsIdAndSeasonsTvShowsId(season_id, show_id).stream()
				.map(chapter -> modelMapper.map(chapter, ChaptersRest.class))
				.collect(Collectors.toList());
	}

	@Override
	public ChaptersRest findSeasonOfSeasonAndShowNumber(Long seasonsId, Long id) {
		 return modelMapper.map(repositoryChapters.findByIdAndSeasonsId (seasonsId, id), ChaptersRest.class);
	}

}
