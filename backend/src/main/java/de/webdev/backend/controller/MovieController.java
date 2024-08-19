package de.webdev.backend.controller;

import de.webdev.backend.dto.MovieDto;
import de.webdev.backend.model.Movie;
import de.webdev.backend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public Movie postMovie(@RequestBody MovieDto userEntries){
        return movieService.addMovie(userEntries);
    }
}
