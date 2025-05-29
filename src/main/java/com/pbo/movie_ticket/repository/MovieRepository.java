package com.pbo.movie_ticket.repository;

import com.pbo.movie_ticket.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, String> {
     List<Movie> findByTitleContainingIgnoreCase(String title);
     
    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE LOWER(g) LIKE LOWER(CONCAT('%', :genre, '%'))")
    List<Movie> findByGenre(@Param("genre") String genre);
     
     
}
