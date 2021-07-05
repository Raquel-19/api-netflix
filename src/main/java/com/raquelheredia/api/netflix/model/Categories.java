package com.raquelheredia.api.netflix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "CATEGORIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories implements Serializable {
	
	private static final long serialVersionUID = 1513026331493421736L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (name = "NAME")
	private String name;
	
	@ManyToMany (mappedBy= "category" , fetch = FetchType.LAZY, targetEntity = TVShows.class)
	@OrderBy ("name")
	private List <TVShows> shows = new ArrayList <>();
}
