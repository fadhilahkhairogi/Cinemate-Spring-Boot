package com.pbo.movie_ticket.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "movie")
public class Movie extends Product implements ListStringable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;
    

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<String> genres = new ArrayList<>();;

    @Column(name = "release_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Column(name = "duration")
    private String duration;
    
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Schedule> schedule = new ArrayList<>();
    
    @Transient
    private List<LocalDateTime> scheduleTime;
    
    @Transient
    private String genresString;

    public Movie(){
//        initializeSeats();
    }
    
    public Movie(String name, List<String> genres, LocalDate releaseDate, String duration,
                 List<Schedule> schedule, String posterUrl, String description) {
        this.name = name;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.schedule = schedule;
        this.posterUrl = posterUrl;
        this.description = description;
        setGenresString();
//        initializeSeats();
    }

    public List<LocalDateTime> getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(List<LocalDateTime> scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
    
    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
    
//    private void initializeSeats() {
//        for (char row = 'A'; row <= 'K'; row++) {
//            for (int col = 1; col <= 13; col++) {
//                String seat = row + String.valueOf(col);
//                seats.put(seat, true); // all seats available initially
//            }
//        }
//    }
    
    
    @Override
    public String ListToString(List<String> list) {
        return String.join("/", list);
    }
    public String getGenresString() {
        return genresString;
    }

    public void setGenresString() {
        this.genresString = ListToString(genres);;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }


    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }





//    public Map<String, Boolean> getSeats() {
//        return seats;
//    }
//
//    public void setSeats(Map<String, Boolean> seats) {
//        this.seats = seats;
//    }



    
}
