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

			//For loop through enums
			for (GameReviews review : GameReviews.values()) {
				
				//Create game review object
				JSONObject gameReviews = new JSONObject();

				gameReviews.put("name", review.setName());
				gameReviews.put("date", review.setDate());
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


	// used to return the model and type of the guitar
	public static String readJSON(String selected){
		String result, name, date, score;

		JSONObject object = buildJSON();

		try {
			name = object.getJSONObject("gameReviews").getJSONObject(selected).getString("name");
			date = object.getJSONObject("gameReviews").getJSONObject(selected).getString("date");
			score = object.getJSONObject("gameReviews").getJSONObject(selected).getString("score");

			result = "Name: "+ name + "\r\n" 
					+"Date: " + date + "\r\n"
					+"Score: " + score + "\r\n";
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
		}		
		
		return result;
	}
}

//	// this is solely for returning the price of the guitar
//	public static String getScore(String selected){
//		String scoreReturn;
//
//		JSONObject object = buildJSON();
//
//		try {
//			scoreReturn = object.getJSONObject("json").getJSONObject(selected).getString("score");
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			scoreReturn = e.toString();
//		}
//
//		return scoreReturn;
//	}
//}
