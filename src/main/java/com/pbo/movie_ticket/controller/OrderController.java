package com.pbo.movie_ticket.controller;

import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.model.Order;
import com.pbo.movie_ticket.model.Schedule;
import com.pbo.movie_ticket.service.MovieService;
import com.pbo.movie_ticket.service.OrderService;
import com.pbo.movie_ticket.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MovieService movieService;
    
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/movie/{movieId}/order")
    public String showOrderForm(@PathVariable Long movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        List<Schedule> schedules = scheduleService.getSchedulesByMovieId(movieId);

        model.addAttribute("movie", movie);
        model.addAttribute("schedules", schedules);
        model.addAttribute("order", new Order());

        return "Order";
    }
    
    @PostMapping("/movie/{movieId}/order")
    public String createOrder(@PathVariable Long movieId, @ModelAttribute Order order) {
        Schedule schedule = scheduleService
            .getScheduleByMovieIdAndTime(movieId, order.getSelectedSchedule());
        Movie movie = movieService.getMovieById(movieId);
        orderService.createOrder(movie, schedule, order.getSelectedSeats());

        return "redirect:/movies/view";
    }


//    @PostMapping("/order/add")
//    public String addOrder(@ModelAttribute Order order) {
//        orderService.saveOrder(order);
//        return "redirect:/order";
//    }
//
//    @GetMapping("/order")
//    public String showAllOrders(Model model) {
//        List<Order> orders = orderService.getAllOrders();
//        model.addAttribute("orders", orders);
//        return "order-list";
//    }
}
