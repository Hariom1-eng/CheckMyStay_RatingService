package com.RatingService.Entities;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;


@Entity
@Table(name="user_rating")
public class Rating {

	   @Id
		private String ratingId;
		private String userId;
		private String hotelId;
//		private String hotelName;
		private  int rating;
		private String title;
		private  String feedback;
		@Column(columnDefinition = "TEXT")
		private String imageUrl;
		public Rating(String ratingId, String userID, String hotelId, int rating, String title, String feedback, String imageUrl) {
			super();
			this.ratingId = ratingId;
			this.userId = userID;
			this.hotelId = hotelId;
//			this.hotelName=hotelName;
			this.rating = rating;
			this.title= title;
			this.feedback = feedback;
			this.imageUrl=imageUrl;
		}
		public Rating() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getRatingId() {
			return ratingId;
		}
		public void setRatingId(String ratingId) {
			this.ratingId = ratingId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getHotelId() {
			return hotelId;
		}
		public void setHotelId(String hotelId) {
			this.hotelId = hotelId;
		}
		
//		public String getHotelName() {
//			return hotelName;
//		}
//		public void setHotelName(String hotelName) {
//			this.hotelName=hotelName;
//		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title=title;
		}
		public String getFeedback() {
			return feedback;
		}
		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		public String getImageUrl() {
			return  imageUrl;
		}
		
		public void  setImageUrl(String imageUrl){
			this.imageUrl=imageUrl;
		}
		@Override
		public String toString() {
			return "Rating [ratingId=" + ratingId + ", UserID=" + userId + ", hotelId=" + hotelId + ", rating=" + rating
					+ "title=" + title +", feedback=" + feedback + "]";
		}
	
		
}
