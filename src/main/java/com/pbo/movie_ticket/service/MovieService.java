/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Asus
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Create or Update movie
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get a movie by ID
    public Optional<Movie> getMovieById(String movieId) {
        return movieRepository.findById(movieId);
    }

    // Delete a movie by ID
    public void deleteMovie(String movieId) {
        movieRepository.deleteById(movieId);
    }
}