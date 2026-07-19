package com.RatingService.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.RatingService.Entities.Rating;
import com.RatingService.ServiceP.RatingService;
import com.RatingService.ServiceP.CloudinaryService;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	 @Autowired
	    private CloudinaryService cloudinaryService;
	
// 1  Create rating 
	// Create Rating
	    @PostMapping(value = "/create", consumes = "multipart/form-data")
	    public ResponseEntity<Rating> create(

	            @RequestParam("userId") String userId,
	            @RequestParam("hotelId") String hotelId,
	            @RequestParam("rating") int rating,
	            @RequestParam("title") String title,
	            @RequestParam("feedback") String feedback,
	            @RequestParam(value = "image", required = false) MultipartFile image

	    ) throws IOException {

	        Rating review = new Rating();

	        review.setRatingId(UUID.randomUUID().toString());
	        review.setUserId(userId);
	        review.setHotelId(hotelId);
	        review.setRating(rating);
	        review.setTitle(title);
	        review.setFeedback(feedback);

	        if (image != null && !image.isEmpty()) {

	            String imageUrl = cloudinaryService.uploadFile(image);

	            review.setImageUrl(imageUrl);
	        }

	        Rating saved = ratingService.create(review);

	        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	    }

	
//	2 get All by  User Id
	
    @GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
	
//	 3 Get All by HotelId
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}
	
	
	@GetMapping("all")
	
     public ResponseEntity<List<Rating>> getRatings(){
		
		return ResponseEntity.ok(ratingService.getRatings());
	}
	
	
	@DeleteMapping("/delete/{ratingId}")
	public ResponseEntity<String> deleteRating(
	        @PathVariable String ratingId) {

	    ratingService.deleteRating(ratingId);

	    return ResponseEntity.ok("Rating deleted successfully");
	}
	
	
	@DeleteMapping("/delete/delete-multiple")
	public ResponseEntity<String> deleteMultipleRatings(
	        @RequestBody List<String> ratingIds) {

	    ratingService.deleteMultipleRatings(ratingIds);

	    return ResponseEntity.ok("Ratings deleted successfully");
	}
	
}
