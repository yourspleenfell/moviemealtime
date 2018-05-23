package com.darbuth.moviemealtime.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.darbuth.moviemealtime.models.Movie;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Long> {
	Movie findByTitle(String title);
}
