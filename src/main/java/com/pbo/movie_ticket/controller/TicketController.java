/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;


import com.pbo.movie_ticket.model.Ticket;
import com.pbo.movie_ticket.service.TicketService;
/**
 *
 * @author Asus
 */
@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public String listTickets(Model model) {
        List<Ticket> tickets = ticketService.getAllTickets();
        model.addAttribute("tickets", tickets);
        return "ticket_list";
    }

    @GetMapping("/tickets/new")
    public String showForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket_form";
    }

    @PostMapping("/tickets")
    public String createTicket(@ModelAttribute Ticket ticket) {
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }
}

