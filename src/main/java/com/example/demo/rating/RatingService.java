package com.example.demo.rating;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    @Autowired
    public RatingService(RatingRepository ratingRepository)
    {
        this.ratingRepository = ratingRepository;
    }
    public List<Rating> getRating()
    {
        return ratingRepository.findAll();
    }
    public void addRating(Rating rating)
    {
        System.out.println(rating);
        ratingRepository.save(rating);
    }

    public void deleteRating(int ratingId)
    {
        if(!ratingRepository.existsById(ratingId))
        {
            return;
        }
        ratingRepository.deleteById(ratingId);
    }
    @Transactional
    public void updateRating(int ratingId, int rating, String description)
    {
        Rating rate = ratingRepository.findById(ratingId).orElseThrow(() -> new IllegalStateException("no teacher"));
        rate.setRating(rating);
        rate.setDescription(description);
    }
}
