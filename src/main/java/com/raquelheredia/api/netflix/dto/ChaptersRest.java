package com.raquelheredia.api.netflix.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChaptersRest implements Serializable {

	private static final long serialVersionUID = 3406845339484198224L;

	@JsonProperty(value = "ID")
	private Long id;

	private String name;
	private Integer duration;

	// private Long seasons;
}
