package com.raquelheredia.api.netflix.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.dto.ActorsRestWithTVShows;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.exceptions.NotFoundException;
import com.raquelheredia.api.netflix.model.Actors;
import com.raquelheredia.api.netflix.repository.ActorsRepository;
import com.raquelheredia.api.netflix.services.ActorsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActorsServiceImpl implements ActorsService {

	private final ActorsRepository repositoryActors;

	private final ModelMapper modelMapper;

	@Override
	public ActorsRest updateActor(Long actorId, String newName, String newLastName) throws NetflixExceptions {
		Actors ac = repositoryActors.findById(actorId)
				.orElseThrow(() -> new NotFoundException("EL ACTOR NO SE PUDO ACTUALIZAR"));
		;

		/*
		 * if (ac == null) { throw new
		 * NotFoundException("EL ACTOR NO SE PUDO ACTUALIZAR");
		 * 
		 * }
		 */

		ac.setName(newName);
		ac.setLast_name(newLastName);
		return modelMapper.map(repositoryActors.save(ac), ActorsRest.class);
	}

	@Override
	public ActorsRest createActor(Actors actor) throws NetflixExceptions {
		Optional<Actors> ac = repositoryActors.findById(actor.getId());

		if (ac.isPresent()) { // Si el id existe...
			throw new NotFoundException("EL ACTOR NO SE PUDO CREAR");

		}
		return modelMapper.map(repositoryActors.save(actor), ActorsRest.class);
	}

	@Override
	public ActorsRest findById(Long actorId) throws NetflixExceptions {

		Actors ac = repositoryActors.findById(actorId)
				.orElseThrow(() -> new NotFoundException("ACTOR NO ENCONTRADO. POR FAVOR, ESCRIBA OTRO ID."));
//		
//		if (ac == null) 
//			throw new NotFoundException("ACTOR NO ENCONTRADO. POR FAVOR, ESCRIBA OTRO ID.");

		return modelMapper.map(ac, ActorsRest.class);
	}
	/*
	 * return repositoryActors.findById(id).map(actor -> modelMapper.map(actor,
	 * ActorsRest.class)) .orElseThrow(() -> new Exception("NO EXISTE EL ID"));
	 */
	// return modelMapper.map(repositoryActors.findById(id).get(),
	// ActorsRest.class);

	@Override
	public List<ActorsRest> findAllActors() throws NetflixExceptions {

		List<Actors> ac = repositoryActors.findAll();

		if (ac.size() == 0)
			throw new NotFoundException("ACTORES NO ENCONTRADOS");

		return ac.stream().map(actor -> modelMapper.map(actor, ActorsRest.class)).collect(Collectors.toList());
	}

	@Override
	public void deleteActor(Long actorId) throws NetflixExceptions {
		Actors ac = repositoryActors.findById(actorId)
				.orElseThrow(() -> new NotFoundException("EL ACTOR NO SE PUDO ELIMINAR POR QUE NO EXISTE"));

		repositoryActors.deleteById(actorId);
	}

	@Override
	public ActorsRestWithTVShows findShowsAndChaptersOfSpecificActor(Long actorsId) throws NetflixExceptions {
		Actors ac = repositoryActors.findById(actorsId)
				.orElseThrow(() -> new NotFoundException("ACTOR NO ENCONTRADO. POR FAVOR, ESCRIBA OTRO ID."));

		return modelMapper.map(ac, ActorsRestWithTVShows.class);
	}

}
