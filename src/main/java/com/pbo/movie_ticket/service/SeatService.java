package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Seat;
import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.repository.SeatRepository;
import com.pbo.movie_ticket.repository.MovieRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepo;

    @Autowired
    private MovieRepository movieRepo;

    // Get seats for a movie's schedule time
    public List<Seat> getSeatsByMovieAndSchedule(String movieId, LocalDateTime scheduleTime) {
        Movie movie = movieRepo.findById(movieId)
            .orElseThrow(() -> new RuntimeException("Movie not found"));
        return seatRepo.findByMovieAndScheduleTime(movie, scheduleTime);
    }

    // Book a seat
    public Seat bookSeat(Long seatId) {
        Seat seat = seatRepo.findById(seatId)
            .orElseThrow(() -> new RuntimeException("Seat not found"));
        if (seat.isBooked()) {
            throw new RuntimeException("Seat already booked");
        }
        seat.setBooked(true);
        return seatRepo.save(seat);
    }

    // Other seat-related business logic ...
}
