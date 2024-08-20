package de.webdev.backend.service;

import de.webdev.backend.dto.MovieDto;
import de.webdev.backend.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(String id);
    Movie addMovie(MovieDto userEntries);

    String deleteMovie(String id);
}
