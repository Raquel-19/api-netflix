package com.raquelheredia.api.netflix.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.services.ActorsService;

@RestController
@RequestMapping ("/api/netflix/v1/actors")
public class ActorsController {

private final ActorsService actorsService;
	
	public ActorsController (ActorsService actorsService) {
		this.actorsService = actorsService;
	}
	
	/**
	 * RETRIEVE: Consultar el listado de actores.
	 */
	@GetMapping ("/")
	public List <ActorsRest> findAllActors() throws NetflixExceptions {
		return actorsService.findAllActors ();
		
	}
	
	/**
	 * RETRIEVE: Consultar la ficha de un actor en concreto.
	 * @throws Exception 
	 */
	@GetMapping ("/{id}")
	public ResponseEntity<ActorsRest> findById(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().body(actorsService.findById(id));
	}
	
	/**
	 * CREATE: Crear un nuevo actor.
	 * 
	 * REVISAR!
	 */
	@PostMapping ("/create_actor")
	public ResponseEntity <ActorsRest> createActor (@RequestBody ActorsRest actor) throws URISyntaxException {
		if (actor.getId() !=null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		ActorsRest actorBD = actorsService.createActor(actor);
		return ResponseEntity
				.created(new URI("/api/actors/" + actorBD.getId()))
				.body (actorBD);
	}
	
	/**
	 * UPDATE: Actualizar los datos de un actor en concreto.
	 * 
	 * REVISAR!
	 */
	@PutMapping ("/update_actor")
	public ResponseEntity <ActorsRest> updateActor (@RequestBody ActorsRest actor) {
		if (actor.getId()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(actorsService.updateActor(actor));
	}
	
	/**
	 * DELETE: Borrar un actor en concreto.
	 * 
	 * REVISAR!
	 */
	@DeleteMapping ("/delete_actor/{id}")
	public ResponseEntity <ActorsRest> deleteActor (Long id) {
		actorsService.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
}
