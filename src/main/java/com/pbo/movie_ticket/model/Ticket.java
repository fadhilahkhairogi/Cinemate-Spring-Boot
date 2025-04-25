/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.model;
import jakarta.persistence.*;
/**
 *
 * @author Asus
 */
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int nomorKursi;
    private int harga;
    private int jamTayang;
    private int price;

    // Constructors
    public Ticket() {}

    // Getters
    public int getId() {
        return id;
    }

    public int getNomorKursi() {
        return nomorKursi;
    }

    public int getHarga() {
        return harga;
    }

    public int getJamTayang() {
        return jamTayang;
    }

    public int getPrice() {
        return price;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNomorKursi(int nomorKursi) {
        this.nomorKursi = nomorKursi;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setJamTayang(int jamTayang) {
        this.jamTayang = jamTayang;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Extra Method
    public String showTicketDetails() {
        return "Kursi: " + nomorKursi + ", Harga: " + harga + ", Jam: " + jamTayang;
    }
}
