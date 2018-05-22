package com.darbuth.moviemealtime.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sources")
public class Source {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	
	@Column 
	private final String source;
	
	@Column
	private final Integer value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ratings")
	private Movie movie;
	
	public Source(Long id, String source, Integer value) {
		this.id = id;
		this.source = source;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public String getSource() {
		return source;
	}

	public Integer getValue() {
		return value;
	}
	
}
