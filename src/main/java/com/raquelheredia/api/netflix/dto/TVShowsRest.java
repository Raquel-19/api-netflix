package com.raquelheredia.api.netflix.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TVShowsRest implements Serializable {

	private static final long serialVersionUID = -761341044859198720L;

	@JsonProperty(value = "ID")
	@ApiModelProperty(notes = "This is the primary key of the class TVShows", required = true)
	private Long id;

	private String name;
	private String short_description;
	private String long_description;
	private Integer recommended_age;
	private String advertising;
	private Integer year;

	private List<CategoriesRest> category;
	private List<SeasonRest> seasons;
	private List<ActorsRest> actors;
	private List<AwardsRest> awards;

}
