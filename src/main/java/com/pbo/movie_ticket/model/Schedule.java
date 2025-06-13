package com.pbo.movie_ticket.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "schedule_seats", joinColumns = @JoinColumn(name = "schedule_id"))
    @MapKeyColumn(name = "seat_number")
    @Column(name = "is_available")
    private Map<String, Boolean> seats = new LinkedHashMap<>();

    public Schedule() {}
    
    public Schedule(String timeString, Movie movie) {
        this.time = LocalDateTime.parse(timeString);
        this.movie = movie;
        initializeSeats();
    }

    public Schedule(LocalDateTime time, Movie movie) {
        this.time = time;
        this.movie = movie;
        initializeSeats();
    }

    private void initializeSeats() {
        for (char row = 'A'; row <= 'G'; row++) {
            for (int col = 1; col <= 10; col++) {
                String seat = row + String.valueOf(col);
                seats.put(seat, true);
            }
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Map<String, Boolean> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Boolean> seats) {
        this.seats = seats;
    }
}
