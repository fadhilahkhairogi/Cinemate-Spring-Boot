package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Fnb;
import com.pbo.movie_ticket.repository.FnbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class FnbService {

    private final FnbRepository fnbRepository;

    @Autowired
    public FnbService(FnbRepository fnbRepository) {
        this.fnbRepository = fnbRepository;
    }

    // Retrieve all movies
    public List<Fnb> getAllFnbs() {
        return fnbRepository.findAll();
    }
    
//    public List<Movie> searchFnbs(String title) {
//        return fnbRepository.findByTitleContainingIgnoreCase(title.trim());
//    }
    
//    public List<Movie> filterGenreMovies(String genre) {
//        return movieRepository.findByGenre(genre.trim());
//    }

    // Add a new movie
//    public Movie addMovie(Movie movie) {
//        return movieRepository.save(movie);
//    }
//
//    // Delete a movie
//    public void deleteMovie(String movieId) {
//        movieRepository.deleteById(movieId);
//    }
//
//    // Find a movie by ID
//    public Movie getMovieById(String movieId) {
//        return movieRepository.findById(movieId)
//               .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + movieId));
//    }
}
