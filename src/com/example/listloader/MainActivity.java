package com.example.listloader;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        getSupportFragmentManager()
	        .beginTransaction()
	        .replace(R.id.fragholder, new RssFragment())
	        .commit();
    }
    
    public void clear(View view) {
    	getContentResolver().delete(DataContract.RSS_CONTENT_URI, null, null);
    	getContentResolver().notifyChange(DataContract.RSS_CONTENT_URI, null);
    }
    
    public void load(View view) {
    	RssFetcher.tryFetch(getContentResolver());
    }
   
}