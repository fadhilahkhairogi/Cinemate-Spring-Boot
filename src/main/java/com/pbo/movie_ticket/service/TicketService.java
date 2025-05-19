/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Ticket;
import com.pbo.movie_ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * @author Asus
 */
@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).orElse(null);
    }
}
