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
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Return Thymeleaf HTML view (GET /movies/view)
@GetMapping("/view")
public String showMoviesPage(
    @RequestParam(value = "filter-genre", required = false) String genre,
    @RequestParam(value = "title", required = false) String title,
    Model model) {

    List<Movie> movies;

    boolean hasGenre = genre != null && !genre.isBlank();
    boolean hasTitle = title != null && !title.isBlank();

    if (hasGenre && hasTitle) {

        List<Movie> byTitle = movieService.searchMovies(title.trim());
        movies = byTitle.stream()
                .filter(m -> m.getGenres().stream()
                        .anyMatch(g -> g.equalsIgnoreCase(genre.trim())))
                .toList();

        if (movies.isEmpty()) {
            model.addAttribute("message", "No movies found matching title '" + title + "' and genre '" + genre + "'.");
            movies = movieService.getAllMovies();
        }

    } else if (hasGenre) {
        movies = movieService.filterGenreMovies(genre.trim());
        if (movies.isEmpty()) {
            model.addAttribute("message", "No movies found for genre: " + genre);
            movies = movieService.getAllMovies();
        }

    } else if (hasTitle) {
        movies = movieService.searchMovies(title.trim());
        if (movies.isEmpty()) {
            model.addAttribute("message", "No movies found for title: " + title);
            movies = movieService.getAllMovies();
        }

    } else {
        movies = movieService.getAllMovies();
    }

    model.addAttribute("movies", movies);
    return "movies";
}

    // REST API — Get a movie by ID (JSON)
//    @GetMapping("/{movieId}")
//    @ResponseBody
//    public Movie getMovieById(@PathVariable String movieId) {
//        return movieService.getMovieById(movieId);
//        
//    }
    
//    @GetMapping("/{movieId}/view")
//    public String showMovieDetailPage(@PathVariable String movieId, Model model) {
//        Movie movie = movieService.getMovieById(movieId);
//        model.addAttribute("movie", movie);
//        return "movie-detail"; 
//    }
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
    
    
    
    
    

        // REST API — Add a new movie (JSON)
    @PostMapping
    @ResponseBody
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    // REST API — Delete a movie (JSON)
    @DeleteMapping("/{movieId}")
    @ResponseBody
    public void deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
    }
}