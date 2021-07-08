package com.raquelheredia.api.netflix.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raquelheredia.api.netflix.model.Actors;
import com.raquelheredia.api.netflix.model.TVShows;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude (JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeasonRest implements Serializable {

	private static final long serialVersionUID = 7081867867185090227L;
	
	@JsonProperty (value = "ID")
	private Long id;
	
	private Integer number;
	private String name;
	
	private List <ChaptersRest> chapters;

}
