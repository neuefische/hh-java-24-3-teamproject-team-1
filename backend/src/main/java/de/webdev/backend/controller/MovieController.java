package de.webdev.backend.controller;

import de.webdev.backend.dto.MovieDto;
import de.webdev.backend.model.Movie;
import de.webdev.backend.service.MovieService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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
        Optional<Movie> movieOptional = Optional.ofNullable(movieService.getMovieById(id));
        return movieOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping()
    public Movie postMovie (@RequestBody MovieDto userEntries) {
        return movieService.addMovie(userEntries);

    }

    @DeleteMapping("{id}")
    public String deleteMovie(@PathVariable String id){
        return movieService.deleteMovie(id);
    }

}
