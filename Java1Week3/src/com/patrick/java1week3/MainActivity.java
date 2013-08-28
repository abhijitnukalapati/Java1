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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	Context context;
	SearchForm search;
	PostDisplay posts;
	Boolean connected = false;
	private EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.form);
		
		context = this;
		
		//Add search handler
		Button searchButton = (Button) findViewById(R.id.searchButton);
		mEditText = (EditText) findViewById(R.id.searchField);
		
		searchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getPost(mEditText.getText().toString());
			}
		});
		
		//Detect Network Connection
		connected = WebConnection.getConnectionStatus(context);
		if(connected) {
			Log.i("NETWORK CONNECTION", WebConnection.getConnectionType(context));
		}
		
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
					
					posts.showResult(title, date, url);
					
					Toast toast = Toast.makeText(context, "Valid search: " + results.getString("title"), Toast.LENGTH_SHORT);
					toast.show();
				}
			} catch (JSONException e) {
				Log.e("JSON", e.getLocalizedMessage());
			}
		}
	}
}
