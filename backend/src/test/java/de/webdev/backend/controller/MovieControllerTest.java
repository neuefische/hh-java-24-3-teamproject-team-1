package de.webdev.backend.controller;

import de.webdev.backend.model.Movie;
import de.webdev.backend.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc  
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;



    @Test
    @DirtiesContext
    void getMovie_shouldReturnEmptyList_whenCallInitially() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    @DirtiesContext
    void getMovieById_shouldReturnIsNotFound_whenMovieDoesNotExist() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    @DirtiesContext
    void postMovie_shouldReturnANewMovie() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        
                        {
                        "author": "exampleAuthor",
                        "title": "exampleTitle",
                        "genre": "drama",
                        "publicationDate": "2023-08-16T14:30:00"
                        }
                        """

                ))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                        
                        {
                        "author": "exampleAuthor",
                        "title": "exampleTitle",
                        "genre": "drama",
                        "publicationDate": "2023-08-16T14:30:00"
                        }
                        """
                ))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    @DirtiesContext
    void deleteMovie() throws Exception{
        Movie movie = new Movie(
                "1",
                "titleExample",
                "authorExample",
                "genreExample",
                LocalDateTime.of(2024, 1, 1, 12, 30)
        );
        movieRepository.save(movie);

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/movies/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}