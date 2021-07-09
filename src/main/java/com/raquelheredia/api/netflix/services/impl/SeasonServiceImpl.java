package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.exceptions.NotFoundException;
import com.raquelheredia.api.netflix.model.Seasons;
import com.raquelheredia.api.netflix.repository.SeasonRepository;
import com.raquelheredia.api.netflix.services.SeasonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService{
	
	private final SeasonRepository repositorySeasons;
	
	private final ModelMapper modelMapper;

	@Override
	public List<SeasonRest> findSeasonByShow (Long showsId) throws NetflixExceptions  {
		
		List <Seasons> se = repositorySeasons.findByTvShowsId(showsId);
		
		if(se.size() == 0)
			throw new NotFoundException("TEMPORADAS NO ENCONTRADAS."); 
		
		return se.stream()
				.map(season -> modelMapper.map(season, SeasonRest.class))
				.collect(Collectors.toList());
}
	@Override
	public SeasonRest findSeasonOfASpecificShow (Long seasonsId, Long showsId) throws NetflixExceptions {
		Seasons se = repositorySeasons. findByIdAndTvShowsId  (seasonsId, showsId);
		
		if (se == null) 
			throw new NotFoundException("TEMPORADA Y/O SERIE NO ENCONTRADA.");
		 return modelMapper.map(se, SeasonRest.class);
	}
}
