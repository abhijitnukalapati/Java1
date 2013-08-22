package com.patrick.java1week3;

import java.util.ArrayList;
import java.util.HashMap;

import com.patrick.lib.FileStuff;

import android.content.Context;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.view.View;

public class FavoritePosts extends LinearLayout {

	Spinner favs;
	Context context;
	ArrayList<String> favPosts = new ArrayList<String>();
	
	public FavoritePosts(Context context) {
		super(context);
		
		this.context = context;
		
		LayoutParams lp;
		
		favPosts.add("History");
		favs = new Spinner(context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		favs.setLayoutParams(lp);
		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, favPosts);
		listAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		favs.setAdapter(listAdapter);
		favs.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
				Log.i("Favorite Selected", parent.getItemAtPosition(pos).toString());
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Log.i("Favorite Selected", "None");
			}
			
		});
		
		updateFavorites();
		
		this.addView(favs);

		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
	}
	
	@SuppressWarnings("unused")
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
	
	private void updateFavorites() {
		HashMap<String, String>  history = getHistory();
		for(String key: history.keySet()) {
			favPosts.add(key);
		}
	}

}
