package com.pbo.movie_ticket.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "fnb")
public class Fnb extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fnb_id")
    private Long fnbId;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Integer price;


    public Long getFnbId() {
        return fnbId;
    }

    public void setFnbId(Long fnbId) {
        this.fnbId = fnbId;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    
}
