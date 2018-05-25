package com.darbuth.moviemealtime.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;

@RestController
@RequestMapping("/recipes")
public class Recipes {
	
	private String getRecipe(String query) throws Exception {
		Gson g = new Gson();
	    String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c=" + query;
	    URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    con.setRequestMethod("GET");
	    con.setRequestProperty("User-Agent", "Mozilla/5.0");
	    BufferedReader in = new BufferedReader(
	    	new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer response = new StringBuffer();
	    while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	    }
	    in.close();
	    return g.toJson(response.toString());
	}

	@RequestMapping("/get/{id}")
	public String getRecipes(@PathVariable("id") int id) throws Exception {
		Gson g = new Gson();
	    String url = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + id;
	    URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    con.setRequestMethod("GET");
	    con.setRequestProperty("User-Agent", "Mozilla/5.0");
	    BufferedReader in = new BufferedReader(
	    	new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer response = new StringBuffer();
	    while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	    }
	    in.close();
	    return g.toJson(response.toString());
	}
	
	@RequestMapping("/meals/{id}")
	public List<String> getMeals(@PathVariable(value="id") int id) throws Exception {
		TmdbMovies movies = new TmdbApi("94ad3df05df207c5b0150d0de38b3153\r\n").getMovies();
		MovieDb movie = movies.getMovie(id, "en");
		List<String> categories = new ArrayList<String>();
		List<String> g = new ArrayList<String>();
		for (Genre genre : movie.getGenres()) {
			if (movie.getGenres().size() < 3) {
				while (g.size() < 3) {
					for (Genre gen : movie.getGenres()) {
						g.add(gen.getName());
						if (g.size() >= 3) {
							break;
						}
					}
				}
			} else {
				g.add(genre.getName());
			}
		}
		for (int i = 0; i < g.size(); i++) {
			if (g.contains("Action") || g.contains("Western")) {
				categories.add("Beef");
				continue;
			}
			if (g.contains("Comedy") || g.contains("War")) {
				categories.add("Chicken");
				continue;
			}
			if (g.contains("Romance") || g.contains("Mystery")) {
				categories.add("Seafood");
				continue;
			}
			if (g.contains("Adventure") || g.contains("Science Fiction")) {
				categories.add("Pork");
				continue;
			}
			if (g.contains("Fantasy") || g.contains("Thriller")) {
				categories.add("Lamb");
				continue;
			}
			if (g.contains("Animation") || g.contains("Musicals")) {
				categories.add("Desert");
				continue;
			}
			if (g.contains("TV Movie") || g.contains("Horror")) {
				categories.add("Miscellaneous");
				continue;
			}
			if (g.contains("History")) {
				categories.add("Sides");
				continue;
			}
			if (g.contains("Crime")) {
				categories.add("Pasta");
				continue;
			}
			if (g.contains("Family")) {
				categories.add("Starter");
				continue;
			}
			if (g.contains("Documentary")) {
				categories.add("Vegan");
				continue;
			}
			if (g.contains("Drama")) {
				categories.add("Vegetarian");
				continue;
			}
		}
		List<String> recipes = new ArrayList<String> ();
		for(int i = 0; i < categories.size(); i++) {
			String result = this.getRecipe(categories.get(i));
			recipes.add(result);
			
		}
		return recipes;
	}
}