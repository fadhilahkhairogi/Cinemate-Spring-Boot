package com.pbo.movie_ticket.service;

import com.pbo.movie_ticket.model.Order;
import com.pbo.movie_ticket.model.Movie;
import com.pbo.movie_ticket.model.Schedule;
import com.pbo.movie_ticket.repository.OrderRepository;
//import com.pbo.movie_ticket.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
//    @Autowired
//    private ScheduleRepository scheduleRepository;

    public Order createOrder(Movie movie, Schedule schedule, List<String> selectedSeats) {
        Map<String, Boolean> seats = schedule.getSeats();

        for (String seat : selectedSeats) {
            Boolean available = seats.get(seat);
            if (available == null || !available) {
                throw new IllegalArgumentException("Seat " + seat + " is not available");
            }
        }

        for (String seat : selectedSeats) {
            seats.put(seat, false);
        }

        Order order = new Order();
        order.setSelectedSchedule(schedule.getTime());
        order.setSelectedSeats(selectedSeats);
        order.setPrice(selectedSeats.size() * 50000);
        order.setMovie(movie);

        return orderRepository.save(order);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public String joinList(List<String> list){
        return String.join(", ", list); 
    }

}
