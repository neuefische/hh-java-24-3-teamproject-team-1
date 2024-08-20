package de.webdev.backend.service.impl;

import de.webdev.backend.dto.MovieDto;
import de.webdev.backend.exception.MovieNotFoundException;
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
    }
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

    @Override
    public Movie updateMovie(MovieDto updateMovie, String id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(String.format("Movie with id: %s not found!", id)))
                .withAuthor(updateMovie.author())
                .withGenre(updateMovie.genre())
                .withTitle(updateMovie.title())
                .withPublicationDate(updateMovie.publicationDate());
        return movieRepository.save(movie);
    }
}
