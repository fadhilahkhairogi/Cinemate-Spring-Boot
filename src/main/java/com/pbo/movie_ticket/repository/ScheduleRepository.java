package com.pbo.movie_ticket.repository;

import com.pbo.movie_ticket.model.Schedule;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.apache.el.stream.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByMovie_MovieId(Long movieId);
    Schedule findByMovie_MovieIdAndTime(Long movieId, LocalDateTime time);
}
