package com.example.patrick;

import org.json.JSONObject;
import org.json.JSONException;
import com.example.patrick.GameReviews;

public class json {
	
	public static JSONObject buildJSON() {

		// creation of my Review JSONObject
		JSONObject reviewObject = new JSONObject();
		try {
			// creation of the query JSONObject
			JSONObject queryObject = new JSONObject();

			//For loop through the enums
			for (GameReviews review : GameReviews.values()) {
				
				//Create game review object
				JSONObject gameReviews = new JSONObject();

				gameReviews.put("name", review.setName());
				gameReviews.put("date", review.setDate());
				gameReviews.put("review", review.setReview());
				gameReviews.put("score", review.setScore());

				queryObject.put(review.name().toString(), gameReviews);
			}

			reviewObject.put("gameReviews", queryObject);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reviewObject;
	}


	//Setting up the result text that is populated from the JSON
	public static String readJSON(String selected){
		String result, name, date, review, score;

		JSONObject object = buildJSON();

		try {
			name = object.getJSONObject("gameReviews").getJSONObject(selected).getString("name");
			date = object.getJSONObject("gameReviews").getJSONObject(selected).getString("date");
			review = object.getJSONObject("gameReviews").getJSONObject(selected).getString("review");
			score = object.getJSONObject("gameReviews").getJSONObject(selected).getString("score");

			result = "\r\n" + "Game Title: "+ name + "\r\n" 
					+"Date Published: " + date + "\r\n"
					+"Review Summary: " + review + "\r\n"
					+"Score: " + score + "\r\n";
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
		}		
		
		return result;
	}
}
