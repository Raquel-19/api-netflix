package com.raquelheredia.api.netflix.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorsRestWithTVShows implements Serializable {

	private static final long serialVersionUID = -3551800133915698770L;

	@JsonProperty(value = "ID")
	private Long id;

	private String name;
	private String last_name;

	private List<TVShowsRestWithSeasons> shows;

}
