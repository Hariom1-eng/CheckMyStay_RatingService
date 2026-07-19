package com.RatingService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RatingService.Entities.Rating;
// Use MongoRepository in the case of MongoDB database use 
//Otherwise use the JpasRepository
public interface RatingRepository extends JpaRepository<Rating,String> {

	
//	Custom finder methods 
	
//	 if in case this methods are  not nfound then create them  
	
	List<Rating> findByUserId(String userId);
	
	
	List<Rating> findByHotelId(String hotelId);
}
