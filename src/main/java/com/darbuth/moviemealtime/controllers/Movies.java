package com.darbuth.moviemealtime.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;

@RestController
public class Movies {
	
	private List<MovieDb> movieResults;
	
	@RequestMapping("/movies/show")
	public MovieDb showMovie(@RequestParam(value="id") int id) {
		TmdbMovies movies = new TmdbApi("94ad3df05df207c5b0150d0de38b3153\r\n").getMovies();
		MovieDb movie = movies.getMovie(id, "en");
		return movie;
	}
	
	@RequestMapping("/movies/get")
	public List<MovieDb> getMovie(@RequestParam(value="t") String t) throws IOException {
		TmdbSearch search = new TmdbApi("94ad3df05df207c5b0150d0de38b3153\r\n").getSearch();
		List<MovieDb> res = search.searchMovie(t, 0, "en", false, 1).getResults();
		if (search.searchMovie(t, 0, "en", false, 2).getResults() != null) {
			List<MovieDb> res2 = search.searchMovie(t, 0, "en", false, 2).getResults();
			res.addAll(res2);
		}
		this.movieResults = res;
		List<MovieDb> pageRes = new ArrayList<MovieDb>();
		if (res.size() > 5) {
			for (int i = 0; i < 5; i++) {
				pageRes.add(res.get(i));
			}
			return pageRes;
		} else {
			return res;
		}
	}
	
	@RequestMapping("/movies/search/{page}")
	public List<MovieDb> paginatedMovies(@PathVariable("page") int page) {
		int start = (page - 1) * 5;
		List<MovieDb> pageRes = new ArrayList<MovieDb>();
		for (int i = start; i < start + 5; i++) {
			pageRes.add(movieResults.get(i));
		}
		return pageRes;
	}
}
