package com.example.listloader;

import java.util.ArrayList;

import android.content.ContentValues;

public class ValueCollection {
	
	public ContentValues currentRow = new ContentValues(); 
	public ArrayList<ContentValues> rows = new ArrayList<ContentValues>();
	
	public ContentValues[] getRows() {
		return rows.toArray(new ContentValues[rows.size()]);
	}

}
