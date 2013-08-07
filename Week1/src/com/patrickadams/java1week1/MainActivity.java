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
        tv.setText("Welcome to Java Bank of America. Please use our handy tool below to convert you're dollars into coins:" + "\r\n");
        ll.addView(tv);
        
        //Creating a text field
        String hintText = "Enter Dollar Amount";
        et = new EditText(this);
        et.setHint(hintText);
        //ll.addView(et);
        
        //Creating a submit button
        Button b = new Button(this);
        b.setText("Execute Conversion Magic");
        b.setWidth(500);
        
        //Creating a clear button
        Button clear = new Button(this);
        clear.setText("Start Over");
        clear.setWidth(500);
        
        //Setting up an on-click listener
        b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			//Creates a function that converts dollar amounts into coins
			public void onClick(View v) {
				int quarter = getResources().getInteger(R.integer.quarter);
				int dime = getResources().getInteger(R.integer.dime);
				int nickel = getResources().getInteger(R.integer.nickel);
				int penny = getResources().getInteger(R.integer.penny);
				
				int entry = Integer.parseInt(et.getText().toString());
				
				if (entry > 10000){
					
					result.setText("\r\n" + "We don't have enough coins for you here at this bank, take your money elsewhere!! :)");
					
				} else {
				
					int numQ = (100/quarter)*entry;
					int numD = (100/dime)*entry;
					int numN = (100/nickel)*entry;
					int numP = (100/penny)*entry;
					
					//Array example
					String coins[] = {" quarters,", " dimes,", " nickels, ", " pennys"};

					result.setText("\r\n" + "Would you like that in..."
							+ "\r\n" + numQ + coins[0] + " " + numD + coins[1]
							+ " " + numN + coins[2] + "or " + numP + coins[3]
							+ "?");
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
        
        View views[] = {et, b, clear};
        
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
