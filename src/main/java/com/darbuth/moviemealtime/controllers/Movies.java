package com.darbuth.moviemealtime.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.darbuth.moviemealtime.repositories.MovieRepo;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbFind;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;

@RestController
public class Movies {
	
	private MovieRepo mr;
	
	public Movies(MovieRepo mr) {
		this.mr = mr;
	}
	
	@RequestMapping("/movies/show")
	public MovieDb showMovie(@RequestParam(value="id") int id) {
		TmdbMovies movies = new TmdbApi("94ad3df05df207c5b0150d0de38b3153\r\n").getMovies();
		MovieDb movie = movies.getMovie(id, "en");
		System.out.println(movie);
		return movie;
	}
	
	@RequestMapping("/movies/get")
	public MovieResultsPage getMovie(@RequestParam(value="t") String t) throws IOException {
		TmdbSearch search = new TmdbApi("94ad3df05df207c5b0150d0de38b3153\r\n").getSearch();
		return search.searchMovie(t, 0, "en", false, 1);
	}
}
