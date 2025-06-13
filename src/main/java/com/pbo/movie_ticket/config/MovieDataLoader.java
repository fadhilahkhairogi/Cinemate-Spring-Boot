/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.model.Schedule;
import com.pbo.movie_ticket.repository.MovieRepository;
import java.io.InputStream;
import java.time.LocalDateTime;
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
        if (is == null) {
            System.out.println("ERROR: moviesData.json not found!");
            return;
        }

        List<Movie> movies = Arrays.asList(objectMapper.readValue(is, Movie[].class));

        for (Movie movie : movies) {
            if (movie.getScheduleTime() != null) {
                for (LocalDateTime time : movie.getScheduleTime()) {
                    Schedule schedule = new Schedule(time, movie);
                    movie.getSchedule().add(schedule);
                    // schedule.setMovie(movie);
                }
            }
        }

        movieRepository.saveAll(movies);
    }


}
