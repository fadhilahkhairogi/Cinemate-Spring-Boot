package com.pbo.movie_ticket.controller;

import com.pbo.movie_ticket.model.Seat;
import com.pbo.movie_ticket.service.SeatService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;


@RestController
@RequestMapping("/movies/{movieId}/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<Seat> getSeats(@PathVariable Long movieId,
                               @RequestParam("scheduleTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime scheduleTime) {
        return seatService.getSeatsByMovieAndSchedule(movieId, scheduleTime);
    }

    @PostMapping("/{seatId}/book")
    public Seat bookSeat(@PathVariable Long seatId) {
        return seatService.bookSeat(seatId);
    }

    // Other seat-related endpoints
}
