package com.RatingService.ServiceP;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RatingService.Entities.Rating;

@Service
public interface RatingService {

	
//	create 
	
	Rating create(Rating rating);
	
	
	
//	get Single user id rating  
	
	
	List<Rating>getRatingByUserId(String userId);
	
	
//	get all rating 
	
	
	List<Rating>getRatings();
	
//	get all  rating of the particular hotel 
	
	List<Rating>getRatingByHotelId(String hotelId);
	
	
	// Delete single rating
	void deleteRating(String ratingId);

	// Delete multiple ratings
	void deleteMultipleRatings(List<String> ratingIds);
}
