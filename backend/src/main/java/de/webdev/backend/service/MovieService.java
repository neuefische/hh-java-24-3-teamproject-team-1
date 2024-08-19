package de.webdev.backend.service;

import de.webdev.backend.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(String id);
}
