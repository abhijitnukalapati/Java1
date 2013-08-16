package com.example.java1week2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.patrick.GameReviewThings;
import com.example.patrick.json;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Initializing Constants
		String[] gameTitles = getResources().getStringArray(R.array.gameTitles);
		LinearLayout ll = new LinearLayout(this);
		final TextView resultView = new TextView(this);
		
		//Grab the radio buttons from the GameReviewThings class
		final RadioGroup radioButtons = GameReviewThings.getRadioButtons(this, gameTitles);
		
		//Grab the button from the GameReviewThings class
		LinearLayout buttonView = GameReviewThings.buttonView(this, "Show Game Details");
		Button theButton = (Button) buttonView.findViewById(2);
		theButton.setOnClickListener(new OnClickListener() {
			
			//Populate the result view on tap of the button based off of the id that corresponds
			@Override
			public void onClick(View v) {
				int id = radioButtons.getCheckedRadioButtonId();
				RadioButton rb = (RadioButton)findViewById(id);
				String selected = rb.getText().toString();
				resultView.setText(json.readJSON(selected));
			}
		});
		
		//Set results view
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		resultView.setLayoutParams(lp);
		resultView.setGravity(Gravity.CENTER_HORIZONTAL);
		resultView.setText("\r\n" + "Select a game for more details.");
		
		//Create another linear layout to organize all the parts
		LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        form.setLayoutParams(lp);
		
		form.addView(radioButtons);
		form.addView(buttonView);
		form.addView(resultView);
		ll.addView(form);
		
		//Set content view
		setContentView(ll);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
