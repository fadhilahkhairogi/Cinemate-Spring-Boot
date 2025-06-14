package com.pbo.movie_ticket.repository;

import com.pbo.movie_ticket.model.Movie;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByNameContainingIgnoreCase(String name);
     
    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE LOWER(g) LIKE LOWER(CONCAT('%', :genre, '%'))")
    List<Movie> findByGenre(@Param("genre") String genre);
     
//    Optional<Movie> findById(Long id);
}
