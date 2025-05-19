/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Pemesanan;
import com.pbo.movie_ticket.repository.PemesananRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * @author Asus
 */
@Service
public class PemesananService {
    @Autowired
    private PemesananRepository pemesananRepo;

    public List<Pemesanan> getAll() {
        return pemesananRepo.findAll();
    }

    public Pemesanan save(Pemesanan p) {
        return pemesananRepo.save(p);
    }
}
