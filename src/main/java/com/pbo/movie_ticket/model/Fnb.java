package com.pbo.movie_ticket.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Table(name = "fnb")
public class Fnb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fnb_id")
    private Long fnbId;

    @Column(name = "name")
    private String name;


    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private Integer price;

    @Column(name = "poster_url")
    private String posterUrl;
    
    @Column(name = "description", columnDefinition = "TEXT") 
    private String description;

    public Long getFnbId() {
        return fnbId;
    }

    public void setFnbId(Long fnbId) {
        this.fnbId = fnbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
}
