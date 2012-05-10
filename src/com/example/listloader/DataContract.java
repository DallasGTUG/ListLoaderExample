package com.example.listloader;

import android.net.Uri;

public class DataContract {
	
	public static final Uri RSS_CONTENT_URI = Uri.parse("content://com.example.listloader/rss");
	
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String[] ALL_COLUMNS = new String[] { COLUMN_ID, COLUMN_TITLE, COLUMN_DESCRIPTION };
	
	public static final String ACTION_CLEAR = "com.example.listloader.action.clear";
	public static final String ACTION_FETCH = "com.example.listloader.action.fetch";
	
}
