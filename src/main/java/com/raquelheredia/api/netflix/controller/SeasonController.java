package com.raquelheredia.api.netflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.SeasonRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.responses.NetflixResponse;
import com.raquelheredia.api.netflix.services.SeasonService;
import com.raquelheredia.api.netflix.util.CommonConstants;
import com.raquelheredia.api.netflix.util.UrlConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/netflix/v1/seasons")
@Api(value = "seasonApi", description = "Operations pertaining to Seasons in SeasonApi")
public class SeasonController {

	private final SeasonService seasonService;

	public SeasonController(SeasonService seasonService) {
		this.seasonService = seasonService;
	}
	@GetMapping (UrlConstants.URL_SHOW_ID + UrlConstants.URL_SHOW) 	//@GetMapping("/{showsId}/shows")
	@ApiOperation(value = "Consulta el listado de temporadas de una serie por id", response = SeasonController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<List<SeasonRest>> findSeasonByShow(@PathVariable Long showsId) throws NetflixExceptions {

		return new NetflixResponse<List<SeasonRest>>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, seasonService.findSeasonByShow(showsId));
		// return seasonService.findSeasonByShow(showsId);
	}
	@GetMapping (UrlConstants.URL_SHOW + UrlConstants.URL_SHOW_ID + UrlConstants.URL_SEASON + UrlConstants.URL_SEASON_ID) //@GetMapping("/shows/{showsId}/seasons/{seasonsId}")
	@ApiOperation(value = "Consulta una temporada en concreto de una serie concreta", response = SeasonController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<SeasonRest> findSeasonOfASpecificShow(@PathVariable Long seasonsId,
			@PathVariable Long showsId) throws NetflixExceptions {

		return new NetflixResponse<SeasonRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, seasonService.findSeasonOfASpecificShow(seasonsId, showsId));
		// return seasonService.findSeasonOfASpecificShow (seasonsId, showsId);
	}

}
