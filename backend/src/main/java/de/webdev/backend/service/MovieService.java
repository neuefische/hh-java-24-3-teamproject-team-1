package de.webdev.backend.service;

import de.webdev.backend.dto.MovieDto;
import de.webdev.backend.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie addMovie(MovieDto userEntries);

    Movie updateMovie(MovieDto updateMovie, String id);
}
