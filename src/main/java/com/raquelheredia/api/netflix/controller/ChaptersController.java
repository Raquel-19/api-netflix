package com.raquelheredia.api.netflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.ChaptersRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.responses.NetflixResponse;
import com.raquelheredia.api.netflix.services.ChaptersService;
import com.raquelheredia.api.netflix.util.CommonConstants;
import com.raquelheredia.api.netflix.util.UrlConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(UrlConstants.URL_BASE + UrlConstants.URL_CHAPTER)
@Api(value = "chaptersApi", description = "Operations pertaining to Chapters in ChaptersApi")
public class ChaptersController {

	private final ChaptersService chaptersService;

	public ChaptersController(ChaptersService chaptersService) {
		this.chaptersService = chaptersService;
	}
	@GetMapping (UrlConstants.URL_SEASON + UrlConstants.URL_SHOW_ID + UrlConstants.URL_SEASON + UrlConstants.URL_SEASON_ID + UrlConstants.URL_CHAPTER)
	//@GetMapping("shows/{showsId}/seasons/{seasonsId}/chapters")
	@ApiOperation(value = "Consulta el listado de capitulos de una temporada y una serie en concreto", response = SeasonController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<List<ChaptersRest>> findChaptersOfSpecificSeasonAndShow(@PathVariable Long seasonId,
			@PathVariable Long showId) throws NetflixExceptions {

		return new NetflixResponse<List<ChaptersRest>>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, chaptersService.findChaptersOfSpecificSeasonAndShow(seasonId, showId));
		// return chaptersService.findChaptersOfSpecificSeasonAndShow(seasonsId,
		// showsId);
	}
	//TODO: MODIFICAR PATCHMAPPING -> Cuando se actualiza un campo en el actualizar (Ver PensandoApimente)
	
	@PatchMapping (UrlConstants.URL_CHAPTER_ID + UrlConstants.URL_CHAPTER + UrlConstants.URL_NAME) 
	//@PatchMapping("/{chaptersId}/chapters/{newName}")
	@ApiOperation(value = "Actualiza el nombre de un captitulo", response = TVShowsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<ChaptersRest> updateChapter(@PathVariable Long chapterId, @PathVariable String newName)
			throws NetflixExceptions {
		return new NetflixResponse<ChaptersRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, chaptersService.updateChapter(chapterId, newName));
	}
	@GetMapping (UrlConstants.URL_SHOW + UrlConstants.URL_SHOW_ID + UrlConstants.URL_SEASON + UrlConstants.URL_SEASON_ID + UrlConstants.URL_CHAPTER + UrlConstants.URL_CHAPTER_ID)
	//@GetMapping("/shows/{showsId}/seasons/{seasonsId}/chapters/{chaptersId}")
	@ApiOperation(value = "Consulta un capitulo en concreto de una temporada y una serie concreta", response = SeasonController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<ChaptersRest> findSeasonOfSeasonAndShowNumber(@RequestParam Long chapterId, Long seasonId,
			Long showId) throws NetflixExceptions {

		return new NetflixResponse<ChaptersRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, chaptersService.findSeasonOfSeasonAndShowNumber(chapterId, seasonId, showId));
		// return chaptersService.findSeasonOfSeasonAndShowNumber (id, seasonsId,
		// showsId);
	}
}
