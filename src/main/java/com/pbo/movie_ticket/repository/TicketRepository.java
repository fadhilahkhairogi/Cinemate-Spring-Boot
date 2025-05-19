/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pbo.movie_ticket.repository;

import com.pbo.movie_ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author Asus
 */
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}