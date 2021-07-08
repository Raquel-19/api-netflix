package com.raquelheredia.api.netflix.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.dto.AwardsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.services.ActorsService;
import com.raquelheredia.api.netflix.services.AwardsService;

@RestController
@RequestMapping ("/api/netflix/v1/awards")
public class AwardsController {
	
private final AwardsService awardsService;
	
	public AwardsController (AwardsService awardsService) {
		this.awardsService = awardsService;
	}
	
	/**
	 * RETRIEVE: Consultar el listado de premios.
	 */
	@GetMapping ("/")
	public List <AwardsRest> findAllAwards()  throws NetflixExceptions {
		return awardsService.findAllAwards();
	}
}
