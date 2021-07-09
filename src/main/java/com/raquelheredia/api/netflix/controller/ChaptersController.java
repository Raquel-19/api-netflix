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
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;
import com.raquelheredia.api.netflix.services.ChaptersService;
import com.raquelheredia.api.netflix.services.SeasonService;

@RestController
@RequestMapping ("/api/netflix/v1/chapters")
public class ChaptersController {
	
private final ChaptersService chaptersService;
	
	public ChaptersController (ChaptersService chaptersService) {
		this.chaptersService = chaptersService;
	}
	
	/**
	 * RETRIEVE: Consulta el listado de capitulos de una temporada y una serie en concreto.
	 *
	 */
	@GetMapping("shows/{showsId}/seasons/{seasonsId}/chapters")
	List <ChaptersRest> findChaptersOfSpecificSeasonAndShow (@PathVariable Long seasonsId, @PathVariable Long showsId) throws NetflixExceptions {
		return chaptersService.findChaptersOfSpecificSeasonAndShow(seasonsId, showsId);
	}
	
	/**
	 * UDPDATE: Actualizar el nombre de un capitulo.
	 * 
	 * REVISAR!
	 */
	@PutMapping ("/")
	public ResponseEntity <ChaptersRest> updateChapter (@RequestBody ChaptersRest chapter) {
		if (chapter.getId()==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(chaptersService.updateChapter(chapter));
	}
	
	/**
	 * RETRIEVE: Consulta un número de un capitulo en concreto de un número de temporada en concreto y de una serie en concreta.
	 * 
	 * REVISAR!
	 * 
	 */
	@GetMapping("/shows/{shows-id}/seasons/{season_number}/chapters/{chapters_number}") 
	ChaptersRest findSeasonOfSeasonAndShowNumber (@RequestParam Long id, Long seasonsId, Long showsId) throws NetflixExceptions {
		return chaptersService.findSeasonOfSeasonAndShowNumber (id, seasonsId, showsId);
	}
}

