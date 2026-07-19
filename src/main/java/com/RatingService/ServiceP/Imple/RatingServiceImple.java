package com.RatingService.ServiceP.Imple;

import java.util.List;
import com.RatingService.Exception.ResourceNotFoundException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RatingService.Entities.Rating;
import com.RatingService.Repository.RatingRepository;
import com.RatingService.ServiceP.RatingService;

@Service
public class RatingServiceImple implements RatingService{

	@Autowired
	private  RatingRepository ratingRepository;
	
	@Override
	public Rating create(Rating rating) {
	    rating.setRatingId(UUID.randomUUID().toString());

		return ratingRepository.save(rating) ;
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(userId) ;
	}

	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		return  ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}
	
	
	@Override
	public void deleteRating(String ratingId) {

	    Rating rating = ratingRepository.findById(ratingId)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Rating not found with ID : " + ratingId));

	    ratingRepository.delete(rating);
	}
	
	@Override
	public void deleteMultipleRatings(List<String> ratingIds) {

	    List<Rating> ratings = ratingRepository.findAllById(ratingIds);

	    ratingRepository.deleteAll(ratings);
	}

}
