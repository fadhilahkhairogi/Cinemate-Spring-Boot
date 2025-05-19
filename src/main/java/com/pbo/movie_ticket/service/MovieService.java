package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Retrieve all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Add a new movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Delete a movie
    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
    }

    // Find a movie by ID
    public Movie getMovieById(String movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }
}
