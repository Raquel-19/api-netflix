package com.raquelheredia.api.netflix.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.ChaptersRest;
import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.services.SeasonService;

@RestController
@RequestMapping ("/api/netflix/v1/seasons")
public class SeasonController {
	
private final SeasonService seasonService;
	
	public SeasonController (SeasonService seasonService) {
		this.seasonService = seasonService;
	}
	
	/** 
	 * RETRIEVE: Consulta el listado de temporadas de una serie por ID.
	 */
	@GetMapping ("/shows/{shows_id}")
	List<SeasonRest> findSeasonByShow (@PathVariable Long showsId) throws NetflixExceptions {
		return seasonService.findSeasonByShow(showsId);
	}
	
	/**
	 * RETRIEVE: Consulta una temporada en concreto de una serie en concreto .
	 * 
	 */
	@GetMapping ("/shows/{shows-id}/seasons/{seasons-id}")
	SeasonRest findSeasonOfASpecificShow (@RequestParam Long showsId, Long seasonsId) {
		return seasonService.findSeasonOfASpecificShow (showsId, seasonsId);
	}
	
	
}
