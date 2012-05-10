package com.example.listloader;

import android.content.Intent;
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
    	startService(new Intent(DataContract.ACTION_CLEAR));
    }
    
    public void load(View view) {
    	startService(new Intent(DataContract.ACTION_FETCH));
    }
   
}