package com.example.listloader;

import android.app.IntentService;
import android.content.Intent;

public class MainService extends IntentService {

	public MainService() {
		super("MainService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		String action = intent.getAction();
		if(action.equals(DataContract.ACTION_CLEAR)) {
			getContentResolver().delete(DataContract.RSS_CONTENT_URI, null, null);
	    	getContentResolver().notifyChange(DataContract.RSS_CONTENT_URI, null);
		}
		
		if(action.equals(DataContract.ACTION_FETCH)) {
			RssFetcher.tryFetch(getContentResolver());
		}
	}

}