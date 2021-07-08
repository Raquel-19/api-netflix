package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.repository.SeasonRepository;
import com.raquelheredia.api.netflix.services.SeasonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService{
	
	private final SeasonRepository repositorySeasons;
	
	private final ModelMapper modelMapper;

	@Override
	public List<SeasonRest> findSeasonByShow (Long shows_id)  {
		return repositorySeasons.findByTvShowsId(shows_id).stream()
				.map(season -> modelMapper.map(season, SeasonRest.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public SeasonRest findSeasonOfASpecificShow (Long shows_id, Long seasons_id) {
		//return repositorySeasons.findSeasonOfASpecificShow(shows_id, seasons_id).map(season -> modelMapper.map(season, SeasonRest.class))
				//.orElseThrow(() -> new Exception("NO EXISTEN LOS IDs"));
		 return modelMapper.map(repositorySeasons.findByIdAndTvShowsId (shows_id, seasons_id), SeasonRest.class);
	}
}
