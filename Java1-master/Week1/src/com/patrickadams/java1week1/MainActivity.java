package com.patrickadams.java1week1;

import com.patrickadams.java1week1.R.string;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	LinearLayout ll;
	LinearLayout.LayoutParams lp;
	EditText et;
	TextView result;
	
	//Declaring a Boolean
	boolean thereIsAResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Setting up the linear layout and linear layout params
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
        //Creating the text view
        TextView tv = new TextView(this);
        tv.setText("Welcome to Java Bank of America. Please use our handy tool below to convert you're dollars into Polish Zloty.");
        ll.addView(tv);
        
        //Creating a text field
        String hintText = "Enter Amount in USD or Polish Zloty";
        et = new EditText(this);
        et.setHint(hintText);
        
        //Creating a submit button
        Button b = new Button(this);
        b.setText("Convert Dollars to Zloty");
        b.setWidth(500);
        
        //Creating a submit button
        Button b2 = new Button(this);
        b2.setText("Convert Zloty to Dollars");
        b2.setWidth(500);
        
        //Creating a clear button
        Button clear = new Button(this);
        clear.setText("Start Over");
        clear.setWidth(500);
        
      //Setting up an on-click listener
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			//Creates a function that converts dollar amounts into coins
			public void onClick(View v) {
				String currentRate = getResources().getString(R.string.exchangeRate1);
				float currentRateInt = Float.parseFloat(currentRate);
				
				float entry = Float.parseFloat(et.getText().toString());
				
				if (entry >= 10000){
					
					result.setText("\r\n" + "We don't have enough money to cover your conversion.");
					
				} else {
				
					float convertedAmount = (currentRateInt)*entry;

					result.setText(entry + " USD converts to "
							+ convertedAmount + " Polish Zloty at an exchange rate of " + currentRateInt);
				}
				
				//Use of Boolean
				thereIsAResult = true;
			}
		});
        
      //Setting up an on-click listener
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			//Creates a function that converts dollar amounts into coins
			public void onClick(View v) {
				String currentRate = getResources().getString(R.string.exchangeRate2);
				float currentRateInt = Float.parseFloat(currentRate);
				
				float entry = Float.parseFloat(et.getText().toString());
				
				if (entry >= 10000){
					
					result.setText("\r\n" + "We don't have enough money to cover your conversion.");
					
				} else {
				
					float convertedAmount = (currentRateInt)*entry;

					result.setText("\r\n" + entry + " Polish Zloty converts to "
							+ convertedAmount + " USD at an exchange rate of " + currentRateInt);
				}
				
				//Use of Boolean
				thereIsAResult = true;
			}
		});
        
      //Setting up an on-click listener for the start over button - Clears text so you can start over
        clear.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v){
				if(thereIsAResult){
					result.setText("\r\n" + "Results cleared");
				} else {
					result.setText("\r\n" + "Nothing to clear");
				}
				et.setText("");
			}
        });
        
        //Lays out the view in a custom way
        LinearLayout form = new LinearLayout(this);
        form.setOrientation(LinearLayout.VERTICAL);
        lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        form.setLayoutParams(lp);
        
        //Use of an array
        View views[] = {et, b, b2, clear};
        
        //For loop example, adds each view
        for(View theView : views) {
        	form.addView(theView);
        }
        
        ll.addView(form);
        
        result = new TextView(this);
        ll.addView(result);
        
        setContentView(ll);    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}