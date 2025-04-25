/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.service.MovieService;
/**
 *
 * @author Asus
 */
@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Show all movies
    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies/list";
    }

    // Show the form to create a new movie
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/create";
    }

    // Handle the form submission
    @PostMapping("/create")
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    // Show the form to update an existing movie
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        movieService.getMovieById(id).ifPresent(movie -> model.addAttribute("movie", movie));
        return "movies/edit";
    }

    // Handle the update form submission
    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable String id, @ModelAttribute Movie movie) {
        movie.setMovieId(id);
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    // Delete a movie
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
    
    @GetMapping("/list")
    public String showMoviesList(Model model) {
        // Retrieve movies from the database and add to model
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies/list"; // The name of your HTML file (Thymeleaf template)
    }
}
