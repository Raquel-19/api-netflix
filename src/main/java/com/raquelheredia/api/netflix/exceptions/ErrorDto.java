package com.raquelheredia.api.netflix.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ErrorDto implements Serializable{
	
	private static final long serialVersionUID = -2469847120519097833L;

	private String name;

	private String value;
	
}

