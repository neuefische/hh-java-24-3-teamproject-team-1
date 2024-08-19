package de.webdev.backend.service.impl;

import de.webdev.backend.dto.MovieDto;
import de.webdev.backend.model.Movie;
import de.webdev.backend.repository.MovieRepository;
import de.webdev.backend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    @Override
    public Movie getMovieById(String id) {
        return movieRepository.findById(id).orElse(null);

    @Override
    public Movie addMovie(MovieDto userEntries){
        Movie newMovie = new Movie(
                null,
                userEntries.title(),
                userEntries.author(),
                userEntries.genre(),
                userEntries.publicationDate()
        );

        return movieRepository.save(newMovie);

    }
}
