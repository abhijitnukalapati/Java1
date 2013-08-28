package com.patrick.java1week3;

import android.content.Context;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class PostDisplay extends GridLayout {

	TextView postTitle;
	TextView postDate;
	TextView postUrl;
	ImageView postImage;
	Context context;
	
	public PostDisplay(Context context) {
		super(context);
		
		this.context = context;
		
		this.setColumnCount(1);
		
		TextView postTitleLabel = new TextView(context);
		postTitleLabel.setText("\r\nTitle: " );
		TextView postTitle = (TextView) findViewById(R.id.game_title);
		
		TextView postDateLabel = new TextView(context);
		postDateLabel.setText("Date: ");
		TextView postDate = (TextView) findViewById(R.id.game_date);
		
		TextView postUrlLabel = new TextView(context);
		postUrlLabel.setText("URL: ");
		TextView postUrl = (TextView) findViewById(R.id.game_url);
		
		this.addView(postTitleLabel);
		this.addView(postTitle);
		this.addView(postDateLabel);
		this.addView(postDate);
		this.addView(postUrlLabel);
		this.addView(postUrl);
		
	}
	
	public void showResult(String title, String date, String postURL) {
		postTitle.setText(title);
		postDate.setText(date);
		postUrl.setText(postURL);
	}
	
}
