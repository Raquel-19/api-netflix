package com.raquelheredia.api.netflix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table (name = "ACTORS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actors implements Serializable {
	
	private static final long serialVersionUID = 3981988226386688880L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "NAME")
	private String name;
	@Column (name = "LAST_NAME")
	private String last_name;
	
	@ManyToMany (mappedBy= "actors" , fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@OrderBy ("name")
	private List <TVShows> shows = new ArrayList <>();
}
