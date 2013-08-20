package com.patrick.java1week3;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SearchForm extends LinearLayout {
	
	EditText searchField;
	Button searchButton;
	
	public SearchForm(Context context, String hint, String buttonText) {
		super(context);
		
		LayoutParams lp;
		
		searchField = new EditText(context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		searchField.setLayoutParams(lp);
		searchField.setHint(hint);
		
		searchButton = new Button(context);
		searchButton.setText(buttonText);
		
		this.addView(searchField);
		this.addView(searchButton);
		
		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		
	}
	
	public EditText getField() {
		return searchField;
	}
	
	public Button getButton() {
		return searchButton;
	}

}
