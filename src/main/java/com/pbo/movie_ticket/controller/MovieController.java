package com.pbo.movie_ticket.controller;

import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.service.MovieService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/movies")
public class MovieController  {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

@GetMapping("/view")
public String showMoviesPage (
    @RequestParam(value = "filter-genre", required = false) String genre,
    @RequestParam(value = "title", required = false) String name,
    Model model) {

    List<Movie> movies;

    boolean hasGenre = genre != null && !genre.isBlank();
    boolean hasName = name != null && !name.isBlank();

    if (hasGenre && hasName) {

        List<Movie> byName = movieService.searchMovies(name.trim());
        movies = byName.stream()
                .filter(m -> m.getGenres().stream()
                        .anyMatch(g -> g.equalsIgnoreCase(genre.trim())))
                .toList();

        if (movies.isEmpty()) {
            model.addAttribute("message", "No movies found matching title '" + name + "' and genre '" + genre + "'.");
            movies = movieService.getAllMovies();
        }

    } else if (hasGenre) {
        movies = movieService.filterGenreMovies(genre.trim());
        if (movies.isEmpty()) {
            model.addAttribute("message", "No movies found for genre: " + genre);
            movies = movieService.getAllMovies();
        }

    } else if (hasName) {
        movies = movieService.searchMovies(name.trim());
        if (movies.isEmpty()) {
            model.addAttribute("message", "No movies found for title: " + name);
            movies = movieService.getAllMovies();
        }

    } else {
        movies = movieService.getAllMovies();
    }

    model.addAttribute("movies", movies);
    return "movies";
}


    @GetMapping("/{movieId}")
    public String getMovieDetail(@PathVariable Long movieId, Model model) {
        try {
            Movie movie = movieService.getMovieById(movieId);
            model.addAttribute("movie", movie);
            return "movie-detail"; 
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "404"; 
        }
    }
    
    @GetMapping("/search")
    public String searchMovies(@RequestParam("title") String title,  Model model) {
        if (title == null || title.trim().isEmpty()) {
            List<Movie> movies = movieService.getAllMovies();
            model.addAttribute("movies", movies);
            return "movies";
        }
        
        List<Movie> results = movieService.searchMovies(title.trim());
         
        if (results.isEmpty()) {
            model.addAttribute("message", "No movies found matching '" + title + "'. Showing all movies.");
            List<Movie> movies = movieService.getAllMovies();
            model.addAttribute("movies", movies);
            return "movies";
        }
        model.addAttribute("message", "Search results for '" + title + "'.");
        model.addAttribute("movies", results);
        return "movies"; 
    }

    
    @GetMapping("/genre")
    public String showMoviesGenre(@RequestParam(value = "filter-genre", required = false) String genre,  Model model) {
        if (genre == null || genre.isEmpty()) {
            List<Movie> movies = movieService.getAllMovies();
            model.addAttribute("movies", movies);
            return "movies";
        }
        
        List<Movie> results = movieService.filterGenreMovies(genre.trim());
         
        if (results.isEmpty()) {
            model.addAttribute("message", "No movies found matching genre: " + genre + ". Showing all movies.");
            List<Movie> movies = movieService.getAllMovies();
            model.addAttribute("movies", movies);
            return "movies";
        }
//        model.addAttribute("message", "Movie genre: '" + genre + "'.");
        model.addAttribute("movies", results);
        return "movies"; 
    }
    
    
    
    
    


//    @PostMapping
//    @ResponseBody
//    public Movie addMovie(@RequestBody Movie movie) {
//        return movieService.addMovie(movie);
//    }
//
//    // REST API — Delete a movie (JSON)
//    @DeleteMapping("/{movieId}")
//    @ResponseBody
//    public void deleteMovie(@PathVariable Long movieId) {
//        movieService.deleteMovie(movieId);
//    }
}