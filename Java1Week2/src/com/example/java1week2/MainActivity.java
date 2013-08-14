package com.example.java1week2;

import com.example.patrick.ListViewThings;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Initializing Constants
		String[] spinnerItems = getResources().getStringArray(R.array.spinner_array);
		String[] listViewItems = getResources().getStringArray(R.array.listView_array);
		
		LinearLayout ll = new LinearLayout(this);
		
		LinearLayout listViewAndSpinner = ListViewThings.listViewAndSpinnerWithJSONItems(this, spinnerItems, listViewItems);
		
		ll.addView(listViewAndSpinner);
		
//		ListView theListView = (ListView) listViewAndSpinner.findViewById(2);
		
		setContentView(ll);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
