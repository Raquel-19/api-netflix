package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.TVShowsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.exceptions.NotFoundException;
import com.raquelheredia.api.netflix.model.Categories;
import com.raquelheredia.api.netflix.model.TVShows;
import com.raquelheredia.api.netflix.repository.CategoriesRepository;
import com.raquelheredia.api.netflix.repository.TVShowsRepository;
import com.raquelheredia.api.netflix.services.TVShowsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TVShowsServiceImpl implements TVShowsService {

	private final TVShowsRepository repositoryShows;

	private final CategoriesRepository repositoryCategories;

	private final ModelMapper modelMapper;

	@Override
	public TVShowsRest findById(Long showsId) throws NetflixExceptions {

		TVShows sh = repositoryShows.findById(showsId)
				.orElseThrow(() -> new NotFoundException("SERIE NO ENCONTRADA. POR FAVOR, ESCRIBA OTRO ID"));

		return modelMapper.map(sh, TVShowsRest.class);
	}

	@Override
	public TVShowsRest updateShow(Long showsId, String newName) throws NetflixExceptions {
		TVShows sh = repositoryShows.findById(showsId)
				.orElseThrow(() -> new NotFoundException("EL NOMBRE NO SE PUDO ACTUALIZAR"));

		sh.setName(newName);
		return modelMapper.map(repositoryShows.save(sh), TVShowsRest.class);
	}

	@Override
	public List<TVShowsRest> findByCategoryId(Long categoryId) throws NetflixExceptions {

		List<TVShows> sh = repositoryShows.findByCategoryId(categoryId);

		if (sh.size() == 0)
			throw new NotFoundException("SERIES NO ENCONTRADAS CON LA CATEGORIA SELECCIONADA.");

		return sh.stream().map(show -> modelMapper.map(show, TVShowsRest.class)).collect(Collectors.toList());
	}

	@Override
	public TVShowsRest addCategories(Long categoryId, Long showsId) throws NetflixExceptions {
		Categories ca = repositoryCategories.findById(categoryId).get();
		TVShows sh = repositoryShows.findById(showsId).get();

		if (ca == null) {
			throw new NotFoundException("CATEGORIA NO ENCONTRADA. POR FAVOR, ESCRIBA OTRO ID.");

		}

		if (sh == null) {
			throw new NotFoundException("SERIE NO ENCONTRADA. POR FAVOR, ESCRIBA OTRO ID.");

		}
		sh.getCategory().add(ca);
		return modelMapper.map(repositoryShows.save(sh), TVShowsRest.class);
	}

	@Override
	public void deleteShow(Long showsId) throws NetflixExceptions {
		TVShows sh = repositoryShows.findById(showsId)
				.orElseThrow(() -> new NotFoundException("LA SERIE NO SE PUDO ELIMINAR POR QUE NO EXISTE"));
		repositoryShows.deleteById(showsId);
	}
}
