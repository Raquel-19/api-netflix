package com.raquelheredia.api.netflix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "TV_SHOWS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TVShows implements Serializable {
	
	private static final long serialVersionUID = 1622872903350823159L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (name = "NAME")
	private String name;
	@Column (name = "SHORT_DECRIPTION")
	private String short_description;
	@Column (name = "LONG_DESCRIPTION")
	private String long_description;
	@Column (name = "YEAR")
	private Integer year;
	@Column (name = "RECOMMENDED_AGE")
	private Integer recommended_age;
	@Column (name = "ADVERTISING")
	private String advertising;
	
	//Relación N:N Categories y TV Shows
	@ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@OrderBy ("name")
	@JoinTable (
			name = "CATEGORIES_SHOWS",
			joinColumns = @JoinColumn (name = "TV_SHOWS_ID", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn (name = "CATEGORIES_ID", referencedColumnName = "id"))
	
	private List <Category> category;
	
	//Relación N:N Actors y TV Shows
	@ManyToMany (fetch = FetchType.LAZY)
	@OrderBy ("name")
	@JoinTable (
			name = "ACTORS_SHOWS",
			joinColumns = @JoinColumn (name = "TV_SHOWS_ID", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn (name = "ACTORS_ID", referencedColumnName = "id"))
	
	private List <Actors> actors;
	
	//Relación 1:N TV Shows y Awards
	@OneToMany (mappedBy= "tv_shows")
	@OrderBy ("name")
	private List <Awards> awards = new ArrayList<>();
	
	
	
}
