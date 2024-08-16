package de.webdev.backend.service.impl;

import de.webdev.backend.dto.MovieDto;
import de.webdev.backend.model.Movie;
import de.webdev.backend.repository.MovieRepository;
import de.webdev.backend.service.MovieService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceImplTest {

    private final MovieRepository movieRepository = mock(MovieRepository.class);
    private final MovieService movieService = new MovieServiceImpl(movieRepository);

    LocalDateTime publicationDate = LocalDateTime.of(2023, 8, 16, 14, 30, 0);

    @Test
    void getAllMovies() {
        //GIVEN
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("1", "First movie", "First author",  "exampleGenre", publicationDate));
        movies.add(new Movie("2", "Second movie", "Second author",  "exampleGenre", publicationDate));
        when(movieRepository.findAll()).thenReturn(movies);

        //WHEN
        List<Movie> actual = movieService.getAllMovies();

        //THEN
        assertEquals(movies, actual);
        verify(movieRepository).findAll();
    }

    @Test
    void addMovie() {


        MovieDto movieDto = new MovieDto("exampleTitle", "exampleAuthor", "exampleGenre", publicationDate);
        Movie movie = new Movie(null, "exampleTitle", "exampleAuthor", "exampleGenre", publicationDate);


        when(movieRepository.save(movie)).thenReturn(movie);

        Movie result = movieService.addMovie(movieDto);

        verify(movieRepository).save(movie);

        assertEquals(movie, result);

    }
}