package com.patrick.lib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class WebConnection {
	
	static Boolean connection = false;
	static String connectionType = "Unavailable";
	
	public static String getConnectionType(Context context) {
		netInfo(context);
		return connectionType;
	}
	
	public static Boolean getConnectionStatus(Context context) {
		netInfo(context);
		return connection;
	}
	
	private static void netInfo(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if(ni!= null) {
			if(ni.isConnected()) {
				connectionType = ni.getTypeName();
				connection = true;
			}
		}
	}

}
