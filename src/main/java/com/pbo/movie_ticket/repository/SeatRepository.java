package com.pbo.movie_ticket.repository;

import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.model.Seat;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByMovieAndScheduleTime(Movie movie, LocalDateTime scheduleTime);
}
