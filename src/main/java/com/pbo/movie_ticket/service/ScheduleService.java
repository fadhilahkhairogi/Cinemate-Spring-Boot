package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Schedule;
import com.pbo.movie_ticket.repository.ScheduleRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    

    public Map<String, Boolean> getSeatAvailability(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return schedule.getSeats();
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public List<Schedule> getSchedulesByMovieId(Long movieId) {
        return scheduleRepository.findByMovie_MovieId(movieId);
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
    public Schedule getScheduleByMovieIdAndTime(Long movieId, LocalDateTime time) {
        Schedule schedule = scheduleRepository.findByMovie_MovieIdAndTime(movieId, time);
        if (schedule == null) {
            throw new IllegalArgumentException("Schedule not found");
        }
        return schedule;
    }
}
