package com.pbo.movie_ticket.repository;

import com.pbo.movie_ticket.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, String> {
     List<Movie> findByTitleContainingIgnoreCase(String title);
     List<Movie> findByGenresContainingIgnoreCase(String genre);
}
