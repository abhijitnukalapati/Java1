package com.example.patrick;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout.LayoutParams;

public class ListViewThings {
	
	public static LinearLayout listViewAndSpinnerWithJSONItems(final Context context, final String[] spinnerArray, final String[] listViewArray) {
		
		//Setting up the linear layout and linear layout params
		LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        
      //Spinner adapter
      		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, spinnerArray);
      		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      		
      		//Creating the spinner
      		Spinner viewSpinner = new Spinner(context);
      		viewSpinner.setAdapter(spinnerAdapter);
      		viewSpinner.setId(1);
      		lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
      		viewSpinner.setLayoutParams(lp);
      		viewSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      			
      			@Override
      			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      				Toast.makeText(context, "You have Spinner selected " + spinnerArray[position],  Toast.LENGTH_LONG).show();
      			}
      			
      			@Override
      			public void onNothingSelected(AdapterView<?> arg0) {
      				//TODO auto-generated method stub
      			}
      			
      		});
      		
      		//Create List Adapter
      		ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, listViewArray);
      		
      		//Create List View
      		ListView listView = new ListView(context);
      		listView.setLayoutParams(lp);
      		listView.setAdapter(listAdapter);
      		listView.setId(2);
      		listView.setOnItemClickListener(new OnItemClickListener() {
      			
      			@Override
      			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      				Toast.makeText(context, "You have ListView selected " + listViewArray[position],  Toast.LENGTH_LONG).show();
      			}
      			
      		});
      		
      	//Add Layout View
    		ll.addView(viewSpinner);
    		ll.addView(listView);
        
		return ll;
	}
}
