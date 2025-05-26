package com.example.demo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "destinations")
public class Destination implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(nullable = false)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "cost_estimate")
    private Double costEstimate;

    // Constructeurs
    public Destination() {
    }

    public Destination(String name, String country, String description, String imageUrl, Double rating, Double costEstimate) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.costEstimate = costEstimate;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getCostEstimate() {
        return costEstimate;
    }

    public void setCostEstimate(Double costEstimate) {
        this.costEstimate = costEstimate;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", costEstimate=" + costEstimate +
                '}';
    }
}
