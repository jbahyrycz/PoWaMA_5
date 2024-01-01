package com.example.demo.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/rating")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService)
    {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<Rating> getTeachers()
    {
        return ratingService.getRating();
    }
    @PostMapping
    public void addTeacher(@RequestBody Rating rating)
    {
        ratingService.addRating(rating);
    }
    @DeleteMapping(path = "/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") int ratingId)
    {
        ratingService.deleteRating(ratingId);
    }
    @PutMapping(path = "/{ratingId}")
    public void updateRating(@PathVariable("ratingId") int ratingId,@RequestBody Rating rating)
    {
        ratingService.updateRating(ratingId, rating.getRating(), rating.getDescription());
    }
}
