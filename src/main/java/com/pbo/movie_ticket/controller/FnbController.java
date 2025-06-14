package com.pbo.movie_ticket.controller;

import com.pbo.movie_ticket.model.Fnb;
import com.pbo.movie_ticket.service.FnbService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/fnb")
public class FnbController {

    private final FnbService fnbService;

    @Autowired
    public FnbController(FnbService fnbService) {
        this.fnbService = fnbService;
    }


@GetMapping("/view")
public String showPage(
    Model model) {

    List<Fnb> fnbs;
     fnbs= fnbService.getAllFnbs();
    

    model.addAttribute("fnbs", fnbs);
    return "fnbs";
}


}