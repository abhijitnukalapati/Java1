package com.patrick.java1week3;

import android.widget.TextView;
import android.app.Activity;

public class PostDisplay {

	public static void showResult(Activity activity, String title, String date, String postURL) {
        TextView postTitle = (TextView) activity.findViewById(R.id.game_title);
        TextView postDate = (TextView) activity.findViewById(R.id.game_date);
        TextView postUrl = (TextView) activity.findViewById(R.id.game_url);

        postTitle.setText(title);
		postDate.setText(date);
		postUrl.setText(postURL);
	}
	
}
