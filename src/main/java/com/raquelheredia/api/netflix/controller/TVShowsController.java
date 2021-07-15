package com.raquelheredia.api.netflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.TVShowsRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.responses.NetflixResponse;
import com.raquelheredia.api.netflix.services.TVShowsService;
import com.raquelheredia.api.netflix.util.CommonConstants;
import com.raquelheredia.api.netflix.util.UrlConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/netflix/v1/shows")
@Api(value = "showsApi", description = "Operations pertaining to Shows in ShowsApi")
public class TVShowsController {

	private final TVShowsService showsService;

	public TVShowsController(TVShowsService showsService) {
		this.showsService = showsService;
	}
	@GetMapping (UrlConstants.URL_CATEGORY_ID + UrlConstants.URL_CATEGORY) 	//@GetMapping("/{categoryId}/categories")
	@ApiOperation(value = "Consulta el listado de series pasando el id de categorias", response = TVShowsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<List<TVShowsRest>> findShowsByCategoryId(@PathVariable(value = "categoryId") Long categoryId)
			throws NetflixExceptions {

		return new NetflixResponse<List<TVShowsRest>>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, showsService.findByCategoryId(categoryId));
		// return showsService.findByCategoryId(categoryId);
	}
	@GetMapping (UrlConstants.URL_SHOW_ID) //@GetMapping("/{showsId}")
	@ApiOperation(value = "Consulta una serie por id", response = TVShowsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<TVShowsRest> findById(@PathVariable Long showsId) throws NetflixExceptions {

		return new NetflixResponse<TVShowsRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, showsService.findById(showsId));
		// return ResponseEntity.ok().body(showsService.findById(id));
	}
	@PutMapping (UrlConstants.URL_SHOW_ID + UrlConstants.URL_SHOW + UrlConstants.URL_NAME) 	//@PutMapping("/{showsId}/shows/{newName}")
	@ApiOperation(value = "Actualiza el nombre de una serie", response = TVShowsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<TVShowsRest> updateShow(@PathVariable Long showsId, @PathVariable String newName)
			throws NetflixExceptions {
		return new NetflixResponse<TVShowsRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, showsService.updateShow(showsId, newName));

		/*
		 * if (shows.getId() == null) { return new
		 * ResponseEntity<>(HttpStatus.BAD_REQUEST); } return
		 * ResponseEntity.ok().body(showsService.updateShow(shows));
		 */
	}
	@PostMapping (UrlConstants.URL_CATEGORY + UrlConstants.URL_CATEGORY_ID + UrlConstants.URL_SHOW + UrlConstants.URL_SHOW_ID) //@PostMapping("/category/{categoryId}/shows/{showsId}")
	@ApiOperation(value = "Añade mas de una categoria a una serie", response = TVShowsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<TVShowsRest> addCategories(@PathVariable Long categoryId, @PathVariable Long showsId)
			throws NetflixExceptions {
		return new NetflixResponse<TVShowsRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, showsService.addCategories(categoryId, showsId));
	}

	@DeleteMapping(UrlConstants.URL_SHOW_ID)
	@ApiOperation(value = "Borra una serie junto a sus temporadas y capitulos", response = TVShowsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<TVShowsRest> deleteShow(@PathVariable Long showsId) throws NetflixExceptions {
		showsService.deleteShow(showsId);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.NO_CONTENT),
				CommonConstants.OK);
	}

}
