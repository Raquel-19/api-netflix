package com.raquelheredia.api.netflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquelheredia.api.netflix.dto.ActorsRest;
import com.raquelheredia.api.netflix.dto.ActorsRestWithTVShows;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.model.Actors;
import com.raquelheredia.api.netflix.responses.NetflixResponse;
import com.raquelheredia.api.netflix.services.ActorsService;
import com.raquelheredia.api.netflix.util.CommonConstants;
import com.raquelheredia.api.netflix.util.UrlConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(UrlConstants.URL_BASE + UrlConstants.URL_ACTOR) //@RequestMapping ("/api/netflix/v1/actors")
@Api(value = "actorsApi", description = "Operations pertaining to Actors in ActorsApi")
public class ActorsController {

	private final ActorsService actorsService;

	public ActorsController(ActorsService actorsService) {
		this.actorsService = actorsService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Consulta el listado de actores", response = ActorsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<List<ActorsRest>> findAllActors() throws NetflixExceptions {
		return new NetflixResponse<List<ActorsRest>>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, actorsService.findAllActors());
		// return actorsService.findAllActors ();

	}

	@GetMapping(UrlConstants.URL_ACTOR_ID)
	@ApiOperation(value = "Consulta un actor en concreto", response = ActorsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<ActorsRest> findById(@PathVariable Long actorId) throws NetflixExceptions {

		return new NetflixResponse<ActorsRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, actorsService.findById(actorId));

		// return ResponseEntity.ok().body(actorsService.findById(id));
	}

	@PostMapping(UrlConstants.URL_CREATE_ACTOR)
	@ApiOperation(value = "Crea un actor", response = ActorsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<ActorsRest> createActor(@RequestBody Actors actor) throws NetflixExceptions {
		return new NetflixResponse<ActorsRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, actorsService.createActor(actor));
	}

	/*
	 * if (actor.getId() !=null) return new
	 * ResponseEntity<>(HttpStatus.BAD_REQUEST);
	 * 
	 * ActorsRest actorBD = actorsService.createActor(actor); return ResponseEntity
	 * .created(new URI("/api/actors/" + actorBD.getId())) .body (actorBD);
	 */

	@PutMapping(UrlConstants.URL_ACTOR_ID + UrlConstants.URL_ACTOR + UrlConstants.URL_NAME + UrlConstants.URL_ACTOR + UrlConstants.URL_LAST_NAME)
	//@PutMapping("/{actorId}/actors/{newName}/actors/{newLastName}")
	@ApiOperation(value = "Actualiza los datos de un actor", response = ActorsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<ActorsRest> updateActor(@PathVariable Long actorId, @PathVariable String newName,
			@PathVariable String newLastName) throws NetflixExceptions {
		return new NetflixResponse<ActorsRest>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
				CommonConstants.OK, actorsService.updateActor(actorId, newName, newLastName));
	}

	@DeleteMapping(UrlConstants.URL_ACTOR_ID)
	@ApiOperation(value = "Borra un actor", response = ActorsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	public NetflixResponse<ActorsRest> deleteActor(Long actorId) throws NetflixExceptions {
		actorsService.deleteActor(actorId);
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.NO_CONTENT),
				CommonConstants.OK);
		/*
		 * actorsService.deleteById(id); return ResponseEntity.noContent().build();
		 */

	}
	@GetMapping (UrlConstants.URL_ACTOR_ID + UrlConstants.URL_SEASON + UrlConstants.URL_SHOW) 	//@GetMapping("/{actorsId}/seasons/shows")
	@ApiOperation(value = "Consulta el listado de series y capitulos de un actor en concreto", response = ActorsController.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 200, message = "Successfully!"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")

	})
	ActorsRestWithTVShows findShowsAndChaptersOfSpecificActor(@PathVariable Long actorId) throws NetflixExceptions {
		return actorsService.findShowsAndChaptersOfSpecificActor(actorId);
	}
}
