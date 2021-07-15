package com.raquelheredia.api.netflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.AwardsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.responses.NetflixResponse;
import com.raquelheredia.api.netflix.services.AwardsService;
import com.raquelheredia.api.netflix.util.CommonConstants;
import com.raquelheredia.api.netflix.util.UrlConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/netflix/v1/awards")
@Api(value = "awardsApi", description = "Operations pertaining to Awards in AwardsApi")
public class AwardsController {

	private final AwardsService awardsService;

	public AwardsController(AwardsService awardsService) {
		this.awardsService = awardsService;
	}

	@GetMapping(UrlConstants.URL_FINDALL)
	@ApiOperation(value = "Consulta el listado de premios", response = AwardsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<List<AwardsRest>> findAllAwards() throws NetflixExceptions {

		return new NetflixResponse<List<AwardsRest>>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, awardsService.findAllAwards());

		// return awardsService.findAllAwards();
	}
}
