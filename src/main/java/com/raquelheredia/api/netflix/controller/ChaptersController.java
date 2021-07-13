package com.raquelheredia.api.netflix.controller;

import java.util.List;

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
import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.dto.TVShowsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.responses.NetflixResponse;
import com.raquelheredia.api.netflix.services.ChaptersService;
import com.raquelheredia.api.netflix.services.SeasonService;
import com.raquelheredia.api.netflix.util.CommonConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping ("/api/netflix/v1/chapters")
@Api (value="chaptersApi", description="Operations pertaining to Chapters in ChaptersApi")
public class ChaptersController {
	
private final ChaptersService chaptersService;
	
	public ChaptersController (ChaptersService chaptersService) {
		this.chaptersService = chaptersService;
	}
	
	@GetMapping("shows/{showsId}/seasons/{seasonsId}/chapters")
	@ApiOperation(value = "Consulta el listado de capitulos de una temporada y una serie en concreto", response = SeasonController.class)
	@ApiResponses (value = {
			@ApiResponse (code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse (code = 200, message = "Successfully!"),
			@ApiResponse (code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse (code = 403, message = "Accessing the resource you were trying to reach is forbidden")
			
	})
	public NetflixResponse <List<ChaptersRest>> findChaptersOfSpecificSeasonAndShow (@PathVariable Long seasonsId, @PathVariable Long showsId) throws NetflixExceptions {
		
		return new NetflixResponse <List<ChaptersRest>> (CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, chaptersService.findChaptersOfSpecificSeasonAndShow(seasonsId,showsId));
		//return chaptersService.findChaptersOfSpecificSeasonAndShow(seasonsId, showsId);
	}
	
	@PutMapping ("/{nameId}/chapters/{newName}")
	@ApiOperation(value = "Actualiza el nombre de un captitulo", response = TVShowsController.class)
	@ApiResponses (value = {
			@ApiResponse (code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse (code = 200, message = "Successfully!"),
			@ApiResponse (code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse (code = 403, message = "Accessing the resource you were trying to reach is forbidden")
			
	})
	public NetflixResponse <ChaptersRest> updateChapter (@PathVariable Long nameId, @PathVariable String newName) throws NetflixExceptions {
		return new NetflixResponse <ChaptersRest> (CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, chaptersService.updateChapter(nameId, newName));
	}
	
	@GetMapping("/shows/{shows-id}/seasons/{season_number}/chapters/{chapters_number}") 
	@ApiOperation(value = "Consulta un capitulo en concreto de una temporada y una serie concreta", response = SeasonController.class)
	@ApiResponses (value = {
			@ApiResponse (code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse (code = 200, message = "Successfully!"),
			@ApiResponse (code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse (code = 403, message = "Accessing the resource you were trying to reach is forbidden")
			
	})
	public NetflixResponse <ChaptersRest> findSeasonOfSeasonAndShowNumber (@RequestParam Long id, Long seasonsId, Long showsId) throws NetflixExceptions {
		
		return new NetflixResponse <ChaptersRest>  (CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, chaptersService.findSeasonOfSeasonAndShowNumber(id, seasonsId, showsId));
		//return chaptersService.findSeasonOfSeasonAndShowNumber (id, seasonsId, showsId);
	}
}

