package com.example.learnservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyFristService extends IntentService {

	private static final String TAG = "MyFristService";

	public MyFristService() {
		super("MyFristService");
		// TODO Auto-generated constructor stub
	}
	
	public MyFristService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		Log.d(TAG, "start onHandleIntent ");
		long endTime = System.currentTimeMillis() + 200 * 1000;
		
		while (System.currentTimeMillis() < endTime) {
			synchronized (this) {
				try {
					wait(endTime - System.currentTimeMillis());
				} catch (Exception e) {
				}
			}
		}
		Log.d(TAG, "end onHandleIntent ");
	}

}
