package com.raquelheredia.api.netflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.dto.ChaptersRest;
import com.raquelheredia.api.netflix.dto.TVShowsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.services.TVShowsService;

@RestController
@RequestMapping ("/api/netflix/v1/shows")
public class TVShowsController {
	
private final TVShowsService showsService;
	
	public TVShowsController (TVShowsService showsService) {
		this.showsService = showsService;
	}
	
	/**
	 * RETRIEVE: Consultar el listado de series pasando el ID de Categories.
	 * 
	 */
	 @GetMapping ("/{categoryId}/categories")
	List <TVShowsRest> findShowsByCategoryId (@PathVariable(value = "categoryId") Long categoryId) throws NetflixExceptions {
			return showsService.findByCategoryId(categoryId);
	} 
	 
	/**
	 * RETRIEVE: Consultar una serie por ID.
	 * 
	 * REVISAR!
	 */
	
	@GetMapping ("/{id}")
	public ResponseEntity<TVShowsRest> findById(@PathVariable Long id) throws NetflixExceptions{
		return ResponseEntity.ok().body(showsService.findById(id));
	}
	
	/**
	 * UPDATE: Actualizar el nombre de una serie.
	 * 
	 * REVISAR!
	 */
	@PutMapping ("/update_shows")
	public ResponseEntity<TVShowsRest> updateShow (@RequestBody TVShowsRest shows) {
		if (shows.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(showsService.updateShow(shows));
	}
	
	/**
	 * RETRIEVE: Consultar el listado de series y capitulos en la ficha de un actor en concreto.
	 * 
	 * REVISAR!
	 */
	@GetMapping("/shows/seasons/actors/{actorsId}")
	List <TVShowsRest> findShowsAndChaptersOfSpecificActor (@PathVariable Long actorId) {
		return showsService.findShowsAndChaptersOfSpecificActor(actorId);
	}
	
	/**
	 * DELETE: Borrar una serie (junto a la temporada y capitulos)
	 * 
	 * REVISAR!
	 * @DeleteMapping("/shows/seasons/chapters")
	 */
	
}
