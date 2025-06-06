package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    public List<Movie> searchMovies(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title.trim());
    }
    
    public List<Movie> filterGenreMovies(String genre) {
        return movieRepository.findByGenre(genre.trim());
    }

    // Add a new movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Delete a movie
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    // Find a movie by ID
    public Movie getMovieById(Long movieId) {
        return movieRepository.findById(movieId)
               .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + movieId));
    }
    
//    public boolean isSeatAvailable(Long movieId, String seatNumber) {
//        Movie movie = movieRepository.findById(movieId);
//        return movie.getSeats().getOrDefault(seatNumber, false);
//    }

//    public boolean bookSeat(Long movieId, String seatNumber) {
//        Movie movie = movieRepository.findById(movieId);
//        if (movie.getSeats().getOrDefault(seatNumber, false)) {
//            movie.getSeats().put(seatNumber, false);
//            movieRepository.save(movie); // persist the update
//            return true;
//        }
//        return false;
//    }

//    public boolean cancelSeat(Long movieId, String seatNumber) {
//        Optional<Movie> movie = movieRepository.findById(movieId);
//        if (movie.getSeats().containsKey(seatNumber) && !movie.getSeats().get(seatNumber)) {
//            movie.getSeats().put(seatNumber, true);
//            movieRepository.save(movie); // persist the update
//            return true;
//        }
//        return false;
//    } 
}
