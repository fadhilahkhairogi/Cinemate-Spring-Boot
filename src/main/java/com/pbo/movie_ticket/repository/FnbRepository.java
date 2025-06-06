package com.pbo.movie_ticket.repository;

import com.pbo.movie_ticket.model.Fnb;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FnbRepository extends JpaRepository<Fnb, Long> {
     List<Fnb> findByNameContainingIgnoreCase(String name);
    
     
}
