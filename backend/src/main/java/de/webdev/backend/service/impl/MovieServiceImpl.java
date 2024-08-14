package de.webdev.backend.service.impl;

import de.webdev.backend.model.Movie;
import de.webdev.backend.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Override
    public List<Movie> getAllMovies() {
        return List.of();
    }
}
