package com.patrick.java1week3;

import com.patrick.lib.WebConnection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	Context context;
	LinearLayout ll;
	SearchForm search;
	PostDisplay posts;
	FavoritePosts favorites;
	Boolean connected = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = this;
		ll = new LinearLayout(this);
		
		search = new SearchForm(context, "Enter Game Name", "GO");
		
		//Add search handler
		Button searchButton = search.getButton();
		
		searchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.i("Click Handler", search.getField().getText().toString());
			}
		});
		
		//Detect Network Connection
		connected = WebConnection.getConnectionStatus(context);
		if(connected) {
			Log.i("NETWORK CONNECTION", WebConnection.getConnectionType(context));
		}
		
		//Add post display
		posts = new PostDisplay(context);
		
		//Add favorites display
		favorites = new FavoritePosts(context);
		
		//Add views to main layout
		ll.addView(search);
		ll.addView(posts);
		ll.addView(favorites);
		
		ll.setOrientation(LinearLayout.VERTICAL);
		
		setContentView(ll);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
