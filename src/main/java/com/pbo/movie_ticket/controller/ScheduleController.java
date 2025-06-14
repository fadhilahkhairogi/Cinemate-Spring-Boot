package com.pbo.movie_ticket.controller;

import com.pbo.movie_ticket.service.ScheduleService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{id}/seats")
    public Map<String, Boolean> getSeats(@PathVariable Long id) {
        return scheduleService.getSeatAvailability(id);
    }
}
