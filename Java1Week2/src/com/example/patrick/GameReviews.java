package com.example.patrick;

public enum GameReviews {

	REVIEW1("Plants Vs. Zombies", "August 14th, 2013", "5 stars"),
	REVIEW2("Tiny Thief", "July 10th, 2013", "5 stars"),
	REVIEW3("Tetris Blitz", "May 19th, 2013", "3.5 stars"),
	REVIEW4("Ridiculous Fishing", "January 15th, 2013", "5 Stars"),
	REVIEW5("Kingdom Rush", "June 4th, 2013", "5 Stars");
	
	private final String name;
	private final String date;
	private final String score;
	
	private GameReviews(String name, String date, String score) {
		this.name = name;
		this.date = date;
		this.score = score;
	}
	
	public String setName() {
		return name;
	}
	
	public String setDate() {
		return date;
	}
	
	public String setScore() {
		return score;
	}
	
}
