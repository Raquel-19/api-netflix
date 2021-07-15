package com.raquelheredia.api.netflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.CategoriesRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.responses.NetflixResponse;
import com.raquelheredia.api.netflix.services.CategoriesService;
import com.raquelheredia.api.netflix.util.CommonConstants;
import com.raquelheredia.api.netflix.util.UrlConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/netflix/v1/categories") 
@Api(value = "categoriesApi", description = "Operations pertaining to Categories in CategoriesApi")
public class CategoriesController {

	private final CategoriesService categoriesService;

	public CategoriesController(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta una lista de categorias", response = CategoriesController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<List<CategoriesRest>> findAllCategories() throws NetflixExceptions {
		return new NetflixResponse<List<CategoriesRest>>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, categoriesService.findAllCategories());
		// return categoriesService.findAllCategories ();

	}

	@GetMapping(UrlConstants.URL_CATEGORY_ID)
	@ApiOperation(value = "Consulta una categoria por id", response = CategoriesController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<CategoriesRest> findById(@PathVariable Long categoryId) throws NetflixExceptions {
		return new NetflixResponse<CategoriesRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, categoriesService.findById(categoryId));
		// return ResponseEntity.ok().body(categoriesService.findById(id));
	}
}
