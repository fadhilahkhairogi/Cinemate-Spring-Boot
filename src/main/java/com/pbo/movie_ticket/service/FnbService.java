package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Fnb;
import com.pbo.movie_ticket.repository.FnbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class FnbService {

    private final FnbRepository fnbRepository;

    @Autowired
    public FnbService(FnbRepository fnbRepository) {
        this.fnbRepository = fnbRepository;
    }

    public List<Fnb> getAllFnbs() {
        return fnbRepository.findAll(); // SELECT * from fnb
    }
    
}
