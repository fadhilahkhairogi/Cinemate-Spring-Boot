/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.repository.MovieRepository;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Component
public class MovieDataLoader implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final ObjectMapper objectMapper;

    public MovieDataLoader(MovieRepository movieRepository, ObjectMapper objectMapper) {
        this.movieRepository = movieRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        InputStream is = getClass().getResourceAsStream("/moviesData.json");
        List<Movie> movies = Arrays.asList(objectMapper.readValue(is, Movie[].class));
        movieRepository.saveAll(movies);
    }
}
