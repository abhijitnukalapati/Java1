package com.example.patrick;

import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Context;
import android.widget.Button;

public class GameReviewThings {
	
	public static LinearLayout buttonView(Context context, String buttonText) {
		LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        //Create the submit button
        Button b = new Button(context);
        b.setText(buttonText);
        b.setId(2);
        
        ll.addView(b);
        
        return ll;
        
	}
	
	public static RadioGroup getRadioButtons(Context context, String[] games) {
		RadioGroup radioButtons = new RadioGroup(context);
		
		//Create a radio button for each game
		for(int i=0; i<games.length; i++) {
			RadioButton rb = new RadioButton(context);
			rb.setText(games[i]);
			rb.setId(900 + i);
			radioButtons.addView(rb);
		}
		
		return radioButtons;
	}
	
}
