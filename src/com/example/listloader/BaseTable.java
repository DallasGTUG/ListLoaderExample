package com.example.listloader;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public abstract class BaseTable {
	
	public Cursor query(SQLiteDatabase db, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		return db.query(getTableName(), projection, selection, selectionArgs, null, null, sortOrder);
	}
	
	public int update(SQLiteDatabase db, Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return db.update(getTableName(), values, selection, selectionArgs);
	}
	
	public long insert(SQLiteDatabase db, Uri uri, ContentValues values) {
		return db.insert(getTableName(), null, values);
	}
	
	public int delete(SQLiteDatabase db, Uri uri, String selection, String[] selectionArgs) {
		return db.delete(getTableName(), selection, selectionArgs);
	}
	
	public String getType(Uri uri) {
		return null;
	}

	public abstract String getTableName(); 
	public abstract void onCreate(SQLiteDatabase db);
	public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

}
