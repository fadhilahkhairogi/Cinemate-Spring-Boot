/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.movie_ticket.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 *
 * @author Asus
 */


@MappedSuperclass
public abstract class Product {

    @Column(name = "name")
    protected String name;

    @Column(name = "poster_url")
    protected String posterUrl;

    @Column(name = "description", columnDefinition = "TEXT")
    protected String description;

    public Product() {}

    public Product(String name, String posterUrl, String description) {
        this.name = name;
        this.posterUrl = posterUrl;
        this.description = description;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}


