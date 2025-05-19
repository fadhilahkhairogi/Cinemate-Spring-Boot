/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.model;

/**
 *
 * @author Asus
 */
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pemesanan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@ManyToMany
    //private List<FnB> fnb;

    @ManyToMany
    private List<Ticket> tiket;

    private LocalDateTime tanggalPesan;

    private int totalHarga;

    // Getters and Setters...
}
