package com.patrick.java1week3;

import android.content.Context;
import android.widget.GridLayout;
import android.widget.TextView;

public class PostDisplay extends GridLayout {

	TextView postTitle;
	TextView postDate;
	TextView postUrl;
	Context context;
	
	public PostDisplay(Context context) {
		super(context);
		
		this.context = context;
		
		this.setColumnCount(1);
		
		TextView postTitleLabel = new TextView(context);
		postTitleLabel.setText("\r\nTitle: " );
		postTitle = new TextView(context);
		
		TextView postDateLabel = new TextView(context);
		postDateLabel.setText("Date: ");
		postDate = new TextView(context);
		
		TextView postUrlLabel = new TextView(context);
		postUrlLabel.setText("URL: ");
		postUrl = new TextView(context);
		
		this.addView(postTitleLabel);
		this.addView(postTitle);
		this.addView(postDateLabel);
		this.addView(postDate);
		this.addView(postUrlLabel);
		this.addView(postUrl);
		
	}
	
}
