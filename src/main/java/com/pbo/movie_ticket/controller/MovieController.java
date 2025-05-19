package com.pbo.movie_ticket.controller;

import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Return Thymeleaf HTML view (GET /movies/view)
    @GetMapping("/view")
    public String showMoviesPage(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies); // Add movies to the model
        return "movies"; // maps to movies.html
    }

    // REST API — Get a movie by ID (JSON)
    @GetMapping("/{movieId}")
    @ResponseBody
    public Movie getMovieById(@PathVariable String movieId) {
        return movieService.getMovieById(movieId);
    }

    // REST API — Add a new movie (JSON)
    @PostMapping
    @ResponseBody
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    // REST API — Delete a movie (JSON)
    @DeleteMapping("/{movieId}")
    @ResponseBody
    public void deleteMovie(@PathVariable String movieId) {
        movieService.deleteMovie(movieId);
    }
}