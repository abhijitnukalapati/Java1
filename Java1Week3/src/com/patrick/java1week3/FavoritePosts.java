package com.patrick.java1week3;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.view.View;

public class FavoritePosts extends LinearLayout {
	
	Button add;
	Button remove;
	Spinner favs;
	Context context;
	ArrayList<String> favPosts = new ArrayList<String>();
	
	public FavoritePosts(Context context) {
		super(context);
		
		this.context = context;
		
		LayoutParams lp;
		
		favPosts.add("Select Favorite");
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
		
		add = new Button(context);
		add.setText("+");
		remove = new Button(context);
		remove.setText("-");
		
		this.addView(favs);
		this.addView(add);
		this.addView(remove);
		
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
	}
	
	private void updateFavorites() {
		favPosts.add("Post 1");
		favPosts.add("Post 2");
		favPosts.add("Post 3");
		favPosts.add("Post 4");
		favPosts.add("Post 5");
	}

}
