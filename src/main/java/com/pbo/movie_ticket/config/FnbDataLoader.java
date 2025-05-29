/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbo.movie_ticket.model.Fnb;
import com.pbo.movie_ticket.repository.FnbRepository;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Component
public class FnbDataLoader implements CommandLineRunner {

    private final FnbRepository fnbRepository;
    private final ObjectMapper objectMapper;

    public FnbDataLoader(FnbRepository fnbRepository, ObjectMapper objectMapper) {
        this.fnbRepository = fnbRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        InputStream is = getClass().getResourceAsStream("/fnbsData.json");
        if (is == null) {
            System.out.println("ERROR: fnbsData.json not found!");
            return;
        }
        List<Fnb> fnb = Arrays.asList(objectMapper.readValue(is, Fnb[].class));
        fnbRepository.saveAll(fnb);
        
    }
}
