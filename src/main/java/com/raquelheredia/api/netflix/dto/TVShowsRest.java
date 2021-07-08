package com.raquelheredia.api.netflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raquelheredia.api.netflix.model.Actors;
import com.raquelheredia.api.netflix.model.Categories;
import com.raquelheredia.api.netflix.model.Seasons;
import com.raquelheredia.api.netflix.model.TVShows;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude (JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TVShowsRest implements Serializable{

	private static final long serialVersionUID = -761341044859198720L;
	
	@JsonProperty (value = "ID")
	private Long id;
	
	private String name;
	private String short_description;
	private String long_description;
	private Integer recommended_age;
	private String advertising;
	private Integer year;
	
	private List <Categories> category;
	private List <Seasons> seasons;
	private List <ActorsRest> actors;
	private List <AwardsRest> awards;
	
	
	

}
