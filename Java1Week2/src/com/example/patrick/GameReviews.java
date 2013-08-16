package com.example.patrick;

public enum GameReviews {

	PlantsVsZombies("Plants Vs. Zombies", "August 14th, 2013", "This game is highly addictive!", "5 stars"),
	TinyThief("Tiny Thief", "July 10th, 2013", "This game is probably my favorite game on the iPhone!", "5 stars"),
	TetrisBlitz("Tetris Blitz", "May 19th, 2013", "This game is very fast-paced", "3.5 stars"),
	RidiculousFishing("Ridiculous Fishing", "January 15th, 2013", "This game is very crazy and funny!", "5 Stars"),
	KingdomRush("Kingdom Rush", "June 4th, 2013", "This game is the best game on iPad right now", "5 Stars");
	
	private final String name;
	private final String date;
	private final String review;
	private final String score;
	
	private GameReviews(String name, String date, String review, String score) {
		this.name = name;
		this.date = date;
		this.review = review;
		this.score = score;
	}
	
	public String setName() {
		return name;
	}
	
	public String setDate() {
		return date;
	}
	
	public String setReview() {
		return review;
	}
	
	public String setScore() {
		return score;
	}
	
}
