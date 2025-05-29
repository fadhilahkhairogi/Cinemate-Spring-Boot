package com.pbo.movie_ticket.controller;

import com.pbo.movie_ticket.model.Fnb;
import com.pbo.movie_ticket.service.FnbService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/fnb")
public class FnbController {

    private final FnbService fnbService;

    @Autowired
    public FnbController(FnbService fnbService) {
        this.fnbService = fnbService;
    }

    // Return Thymeleaf HTML view (GET /movies/view)
@GetMapping("/view")
public String showPage(
    Model model) {

    List<Fnb> fnbs;
     fnbs= fnbService.getAllFnbs();
    

    model.addAttribute("fnbs", fnbs);
    return "fnbs";
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
//    @GetMapping("/{fnbId}")
//    public String getMovieDetail(@PathVariable String movieId, Model model) {
//        try {
//            Movie fnb = fnbService.getFnbById(fnbId);
//            model.addAttribute("fnb", fnb);
//            return "fnb-detail"; 
//        } catch (RuntimeException e) {
//            model.addAttribute("errorMessage", e.getMessage());
//            return "404"; 
//        }
//    }
    
//    @GetMapping("/search")
//    public String searchMovies(@RequestParam("title") String title,  Model model) {
//        if (title == null || title.trim().isEmpty()) {
//            List<Movie> movies = movieService.getAllMovies();
//            model.addAttribute("movies", movies);
//            return "movies";
//        }
//        
//        List<Movie> results = movieService.searchMovies(title.trim());
//         
//        if (results.isEmpty()) {
//            model.addAttribute("message", "No movies found matching '" + title + "'. Showing all movies.");
//            List<Movie> movies = movieService.getAllMovies();
//            model.addAttribute("movies", movies);
//            return "movies";
//        }
//        model.addAttribute("message", "Search results for '" + title + "'.");
//        model.addAttribute("movies", results);
//        return "movies"; 
//    }
//
//    
//    @GetMapping("/genre")
//    public String showMoviesGenre(@RequestParam(value = "filter-genre", required = false) String genre,  Model model) {
//        if (genre == null || genre.isEmpty()) {
//            List<Movie> movies = movieService.getAllMovies();
//            model.addAttribute("movies", movies);
//            return "movies";
//        }
//        
//        List<Movie> results = movieService.filterGenreMovies(genre.trim());
//         
//        if (results.isEmpty()) {
//            model.addAttribute("message", "No movies found matching genre: " + genre + ". Showing all movies.");
//            List<Movie> movies = movieService.getAllMovies();
//            model.addAttribute("movies", movies);
//            return "movies";
//        }
////        model.addAttribute("message", "Movie genre: '" + genre + "'.");
//        model.addAttribute("movies", results);
//        return "movies"; 
//    }
//    
//    
//    
//    
//    
//
//        // REST API — Add a new movie (JSON)
//    @PostMapping
//    @ResponseBody
//    public Movie addMovie(@RequestBody Movie movie) {
//        return movieService.addMovie(movie);
//    }
//
//    // REST API — Delete a movie (JSON)
//    @DeleteMapping("/{movieId}")
//    @ResponseBody
//    public void deleteMovie(@PathVariable String movieId) {
//        movieService.deleteMovie(movieId);
//    }
}