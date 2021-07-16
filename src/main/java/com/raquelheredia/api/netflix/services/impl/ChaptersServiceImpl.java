package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.ChaptersRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.exceptions.NotFoundException;
import com.raquelheredia.api.netflix.model.Chapters;
import com.raquelheredia.api.netflix.repository.ChaptersRepository;
import com.raquelheredia.api.netflix.services.ChaptersService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChaptersServiceImpl implements ChaptersService {

	private final ChaptersRepository repositoryChapters;

	private final ModelMapper modelMapper;

	@Override
	public List<ChaptersRest> findChaptersOfSpecificSeasonAndShow(Long seasonId, Long showId)
			throws NetflixExceptions {
		List<Chapters> chap = repositoryChapters.findBySeasonsIdAndSeasonsTvShowsId(seasonId, showId);

		if (chap.size() == 0)
			throw new NotFoundException("CAPITULOS Y/O TEMPORADAS NO ENCONTRADAS");

		return chap.stream().map(chapter -> modelMapper.map(chapter, ChaptersRest.class)).collect(Collectors.toList());
	}

	@Override
	public ChaptersRest findSeasonOfSeasonAndShowNumber(Long chapterId, Long seasonId, Long showId)
			throws NetflixExceptions {
		Chapters ch = repositoryChapters.findByIdAndSeasonsIdAndSeasonsTvShowsId(chapterId, seasonId, showId);

		if (ch == null)
			throw new NotFoundException("CAPITULO, TEMPORADA Y/O SERIE NO ENCONTRADAS");

		return modelMapper.map(ch, ChaptersRest.class);
	}

	@Override
	public ChaptersRest updateChapter(Long chapterId, String newName) throws NetflixExceptions {
		Chapters ch = repositoryChapters.findById(chapterId)
				.orElseThrow(() -> new NotFoundException("EL NOMBRE NO SE PUDO ACTUALIZAR"));
		;

		ch.setName(newName);
		return modelMapper.map(repositoryChapters.save(ch), ChaptersRest.class);
	}
}
