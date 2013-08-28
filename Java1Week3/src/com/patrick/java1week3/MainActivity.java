package com.patrick.java1week3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.patrick.lib.FileStuff;
import com.patrick.lib.WebConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	Context context;
	SearchForm search;
	FavoritePosts favorites;
	Boolean connected = false;
	HashMap<String, String> history;
	
	public void showResult(String title, String date, String postURL) {
		try{
			((TextView) findViewById(R.id.game_title)).setText(title);
			((TextView) findViewById(R.id.game_date)).setText(date);
			((TextView) findViewById(R.id.game_url)).setText(postURL);
		} catch (Exception e) {
			Log.e("JSON ERROR", e.toString());
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.form);
		
		context = this;
		history = getHistory();
		
		if(history != null) {
			Log.i("HISTORY READ", history.toString());
		}
		
		search = new SearchForm(context, "Enter Game Name", "GO");
		
		//Add search handler
		Button searchButton = (Button) findViewById(R.id.searchButton);
		
		searchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getPost(search.getField().getText().toString());
			}
		});
		
		//Detect Network Connection
		connected = WebConnection.getConnectionStatus(context);
		if(connected) {
			Log.i("NETWORK CONNECTION", WebConnection.getConnectionType(context));
		}
		
		//Add favorites display
		favorites = new FavoritePosts(context);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void getPost(String tag) {
		String baseURL = "http://api.tumblr.com/v2/blog/www.theappmob.com/posts?api_key=zoxEpyAIr35TvVt6P6XYGrN5WiENeOrkqP8sECu5XvuIzR5cRP&tag=";
		String baseURLWithTag = baseURL + tag;
		
		URL finalURL;
		try{
			finalURL = new URL(baseURLWithTag);
			PostRequest pr = new PostRequest();
			pr.execute(finalURL);
		} catch (MalformedURLException e) {
			Log.e("BAD URL", "ERROR");
			finalURL = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private HashMap<String, String> getHistory() {
		Object stored = FileStuff.readObjectFile(context, "history", false);
		
		HashMap<String, String> history;
		if(stored == null) {
			Log.i("HISTORY", "NO HISTORY FILE FOUND");
			history = new HashMap<String, String>();
		} else {
			history = (HashMap<String, String>) stored;
		}
		return history;
	}
	
	private class PostRequest extends AsyncTask<URL, Void, String> {
		
		@Override
		protected String doInBackground(URL... urls) {
			String response = "";
			for(URL url: urls) {
				response = WebConnection.getURLStringResponse(url);
			}
			
			return response;
		}
		
		@Override
		protected void onPostExecute(String result) {
			Log.i("URL RESPONSE", result);
			try{
				JSONObject json = new JSONObject(result);
				JSONObject results = json.getJSONObject("response").getJSONArray("posts").getJSONObject(0);
				if(results == null){
					Toast toast = Toast.makeText(context, "No results", Toast.LENGTH_SHORT);
					toast.show();
				} else {
					String title = results.getString("title");
					String date = results.getString("date");
					String url = results.getString("short_url");
					
					showResult(title, date, url);
					
					Toast toast = Toast.makeText(context, "Valid search: " + results.getString("title"), Toast.LENGTH_SHORT);
					toast.show();
					history.put(results.getString("title"), results.toString());
					FileStuff.storeObjectFile(context, "history", history, false);
					FileStuff.storeStringFile(context, "temp", results.toString(), true);
				}
			} catch (JSONException e) {
				Log.e("JSON", e.getLocalizedMessage());
			}
		}
	}

}
