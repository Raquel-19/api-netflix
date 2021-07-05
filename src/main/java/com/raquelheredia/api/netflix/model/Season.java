package com.raquelheredia.api.netflix.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "SEASONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Season implements Serializable {
	 
	 private static final long serialVersionUID = -4406366258154780816L;
	 
	 	@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long id;
	 	
	 	@Column (name = "NUMBER")
	 	private Integer number;
	 	@Column (name = "NAME")
	 	private String name;
	 	
		//Relación 1:N Season y Chapters
		@OneToMany (mappedBy= "seasons" , cascade = CascadeType.REMOVE)
		@OrderBy ("name")
		private List <Chapters> chapters = new ArrayList<>();
	

}
