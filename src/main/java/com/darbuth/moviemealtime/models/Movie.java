package com.darbuth.moviemealtime.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	
	@Column
	private final String title;
	
	@Column
	private final Integer year;
	
	@Column
	private final String rated;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private final Date release;
	
	@Column
	@DateTimeFormat(pattern = "HH:mm")
	private final Date runtime;
	
	@Column
	private final String genre;
	
	@Column
	private final String director;
	
	@Column
	private final String writer;
	
	@Column
	private final String actors;
	
	@Column
	private final String plot;
	
	@Column
	private final String language;
	
	@Column
	private final String country;
	
	@Column
	private final String awards;
	
	@Column
	private final String poster;
	
	@Column
	private final String ratings;
	
	@OneToMany(mappedBy = "ratings")
	private List<Source> sources;
	
	@Column
	private final Integer metascore;
	
	@Column
	private final Integer imdbRating;
	
	@Column
	private final Integer imdbVotes;
	
	@Column
	private final String imdbId;
	
	@Column
	private final String type;
	
	@Column
	private final String dvd;
	
	@Column
	private final Integer boxOffice;
	
	@Column
	private final String production;
	
	@Column
	private final String website;
	
	@Column
	private final String response;
	
	public Movie(Long id, String title, Integer year, String rated, Date release, Date runtime, String genre, String director, String writer, 
		String actors, String plot, String language, String country, String awards, String poster,	String ratings, List<Source> sources, Integer metascore,
		Integer imdbRating, Integer imdbVotes, String imdbId, String type, String dvd, Integer boxOffice, String production, String website,
		 String response) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.rated = rated;
		this.release = release;
		this.runtime = runtime;
		this.genre = genre;
		this.director = director;
		this.writer = writer;
		this.actors = actors;
		this.plot = plot;
		this.language = language;
		this.country = country;
		this.awards = awards;
		this.poster = poster;
		this.ratings = ratings;
		this.sources = sources;
		this.metascore = metascore;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.imdbId = imdbId;
		this.type = type;
		this.dvd = dvd;
		this.boxOffice = boxOffice;
		this.production = production;
		this.website = website;
		this.response = response;
	
	}
	
	public List<Source> getSources() {
		return sources;
	}

	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getRated() {
		return rated;
	}

	public Date getRelease() {
		return release;
	}

	public Date getRuntime() {
		return runtime;
	}

	public String getGenre() {
		return genre;
	}

	public String getDirector() {
		return director;
	}

	public String getWriter() {
		return writer;
	}

	public String getActors() {
		return actors;
	}

	public String getPlot() {
		return plot;
	}

	public String getLanguage() {
		return language;
	}

	public String getCountry() {
		return country;
	}

	public String getAwards() {
		return awards;
	}

	public String getPoster() {
		return poster;
	}

	public String getRatings() {
		return ratings;
	}

	public Integer getMetascore() {
		return metascore;
	}

	public Integer getImdbRating() {
		return imdbRating;
	}

	public Integer getImdbVotes() {
		return imdbVotes;
	}

	public String getImdbId() {
		return imdbId;
	}

	public String getType() {
		return type;
	}

	public String getDvd() {
		return dvd;
	}

	public Integer getBoxOffice() {
		return boxOffice;
	}

	public String getProduction() {
		return production;
	}

	public String getWebsite() {
		return website;
	}

	public String getResponse() {
		return response;
	}
}
