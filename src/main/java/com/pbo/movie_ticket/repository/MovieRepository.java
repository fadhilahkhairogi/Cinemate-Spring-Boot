package com.pbo.movie_ticket.repository;

import com.pbo.movie_ticket.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
    // Custom queries can go here (e.g., findByTitle, findByGenre, etc.)
}
