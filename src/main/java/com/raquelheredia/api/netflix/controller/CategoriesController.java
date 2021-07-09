package com.raquelheredia.api.netflix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.CategoriesRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.model.Categories;
import com.raquelheredia.api.netflix.services.CategoriesService;

@RestController
@RequestMapping ("/api/netflix/v1/categories")
public class CategoriesController  {
	
	private final CategoriesService categoriesService;
	
	public CategoriesController (CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}
	
	/**
	 * RETRIEVE: Consulta la lista de categorias.
	 */
	@GetMapping ("/")
	public List <CategoriesRest> findAllCategories() throws NetflixExceptions {
		return categoriesService.findAllCategories ();
		
	}
	
	/**
	 * RETRIEVE: Consulta una categoria por ID.
	 * @param id
	 * @return
	 */
	@GetMapping ("/{id}")
	public ResponseEntity<CategoriesRest>findById(@PathVariable Long id) throws NetflixExceptions {
		return ResponseEntity.ok().body(categoriesService.findById(id));
	}
	
	/**
	 * RETRIEVE: Añadir más de una categoria a una serie.
	 * 
	 * REVISAR!
	 */

}
