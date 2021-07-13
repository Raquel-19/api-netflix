package com.raquelheredia.api.netflix.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "CHAPTERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapters implements Serializable{
	 
	private static final long serialVersionUID = 3387099365203261958L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "NUMBER")
	private Integer number;
	
	@Column (name = "NAME")
	private String name;
	
	@Column (name = "DURATION")
	private Integer duration;
	
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn (name = "SEASON_ID")
	private Seasons seasons;

}
