package com.pbo.movie_ticket.model;



import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders") 
public class Order implements ListStringable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    
    @Column(name = "selected_schedule", nullable = false)
    private LocalDateTime selectedSchedule;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ElementCollection
    @CollectionTable(name = "order_selected_seats", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "seat")
    private List<String> selectedSeats;

    @Transient
    private String selectedSeatsString;
    
    public Order() {}

    public Order(Movie movie, LocalDateTime selectedSchedule, List<String> selectedSeats) {
        this.movie = movie;
        this.selectedSchedule = selectedSchedule;
        this.selectedSeats = selectedSeats;
        setSelectedSeatsString();
//        this.price = calculatePrice(selectedSchedule);
    }

//    private int calculatePrice(LocalDateTime schedule) {
//        DayOfWeek day = schedule.getDayOfWeek();
//        return (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) ? 50000 : 35000;
//    }

    public String getSelectedSeatsString() {
        return selectedSeatsString;
    }
    
    
    public void setSelectedSeatsString() {
        this.selectedSeatsString = ListToString(selectedSeats);
    }
    
    
    @Override
    public String ListToString(List<String> list) {
        return String.join(", ", list);
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }

    
    
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getSelectedSchedule() {
        return selectedSchedule;
    }

    public void setSelectedSchedule(LocalDateTime selectedSchedule) {
        this.selectedSchedule = selectedSchedule;
//        this.price = calculatePrice(selectedSchedule); 
    }

    public Integer getPrice() {
        return price;
    }


    public List<String> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(List<String> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

//    public void setSchedule(Schedule schedule) {
//        this.schedule = schedule;
//    }
}
