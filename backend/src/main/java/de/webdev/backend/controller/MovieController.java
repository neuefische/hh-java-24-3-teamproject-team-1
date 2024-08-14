package de.webdev.backend.controller;

import de.webdev.backend.model.Movie;
import de.webdev.backend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping()
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }
}
