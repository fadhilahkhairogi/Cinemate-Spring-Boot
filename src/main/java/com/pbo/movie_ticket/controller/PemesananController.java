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


import com.pbo.movie_ticket.model.Pemesanan;
import com.pbo.movie_ticket.service.PemesananService;
/**
 *
 * @author Asus
 */
@Controller
public class PemesananController {
    @Autowired
    private PemesananService pemesananService;

    @GetMapping("/pemesanan")
    public String list(Model model) {
        model.addAttribute("pemesananList", pemesananService.getAll());
        return "pemesanan";
    }

    @GetMapping("/pemesanan/new")
    public String createForm(Model model) {
        model.addAttribute("pemesanan", new Pemesanan());
        return "create-pemesanan";
    }

    @PostMapping("/pemesanan")
    public String save(@ModelAttribute Pemesanan pemesanan) {
        pemesananService.save(pemesanan);
        return "redirect:/pemesanan";
    }
}

