package de.webdev.backend.service.impl;

import de.webdev.backend.model.Movie;
import de.webdev.backend.repository.MovieRepository;
import de.webdev.backend.service.MovieService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceImplTest {

    private final MovieRepository movieRepository = mock(MovieRepository.class);
    private final MovieService movieService = new MovieServiceImpl(movieRepository);

    @Test
    void getAllMovies() {
        //GIVEN
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("1","First movie", "First author"));
        movies.add(new Movie("2","Second movie", "Second author"));
        when(movieRepository.findAll()).thenReturn(movies);

        //WHEN
        List<Movie> actual = movieService.getAllMovies();

        //THEN
        assertEquals(movies, actual);
        verify(movieRepository).findAll();
    }

    @Test
    void getMovieById_shouldReturnMovie_whenIdExists() {
        Movie movie = new Movie("1", "First movie", "First author");
        when(movieRepository.findById("1")).thenReturn(Optional.of(movie));

        Movie actual = movieService.getMovieById("1");

        assertEquals(movie, actual);
        verify(movieRepository).findById("1");
    }

    @Test
    void getMovieById_shouldReturnNull_whenIdDoesNotExist() {
        when(movieRepository.findById("999")).thenReturn(Optional.empty());

        Movie actual = movieService.getMovieById("999");

        assertNull(actual);
        verify(movieRepository).findById("999");
    }
}