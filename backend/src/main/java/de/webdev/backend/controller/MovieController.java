package de.webdev.backend.controller;

import de.webdev.backend.dto.MovieDto;
import de.webdev.backend.model.Movie;
import de.webdev.backend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

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


    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
        Movie movie= movieService.getMovieById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);

    @PostMapping()
    public Movie postMovie(@RequestBody MovieDto userEntries){
        return movieService.addMovie(userEntries);

    }
}
