package com.pbo.movie_ticket.repository;

import com.pbo.movie_ticket.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
