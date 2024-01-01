package com.example.demo.rating;

import jakarta.persistence.*;

@Entity
@Table
public class Rating {
    @Id
    @SequenceGenerator(name = "rating_sequence", sequenceName = "rating_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_sequence")
    private int id;
    private int rating;
    private String description;
    public Rating() {}
    public Rating(int id, int rating, String description)
    {
        this.id = id;
        this.rating = rating;
        this.description = description;
    }
    public Rating(int rating, String description)
    {
        this.rating = rating;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
