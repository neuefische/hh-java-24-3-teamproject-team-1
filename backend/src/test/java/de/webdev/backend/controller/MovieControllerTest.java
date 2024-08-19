package de.webdev.backend.controller;

import de.webdev.backend.model.Movie;
import de.webdev.backend.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    void getMovie_shouldRetunEmptyList_whenCallInitially() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    void getMovieById_shouldReturnMovie_whenIdExists() throws Exception {
        Movie movie = new Movie("1", "Title", "Author");
        when(movieService.getMovieById("1")).thenReturn(movie);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":\"1\",\"title\":\"Title\",\"author\":\"Author\"}"));
    }

    @Test
    void getMovieById_shouldReturnNotFound_whenIdDoesNotExist() throws Exception {
        when(movieService.getMovieById("999")).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies/999"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}