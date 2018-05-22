package com.darbuth.moviemealtime.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darbuth.moviemealtime.repositories.MovieRepo;

@RestController
public class Movies {
	
	private MovieRepo mr;
	
	public Movies(MovieRepo mr) {
		this.mr = mr;
	}

	@RequestMapping("/movies/search")
	public String movieTitle(@RequestParam(value="title") String title) {
		System.out.print(title);
		return title;
	}
}
