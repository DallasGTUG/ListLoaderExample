package com.example.listloader;

import android.database.sqlite.SQLiteDatabase;

public class RssTable extends BaseTable {

	@Override
	public String getTableName() {
		return "rss";
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// rss create sql
		String sql = "CREATE TABLE rss (" +
		"_id integer primary key autoincrement, " +
		"title text not null, " +
		"description text not null" +
		");";
		db.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS rss");
		onCreate(db);
	}
}
