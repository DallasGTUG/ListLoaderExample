package com.example.listloader;

public class MainProvider extends BaseProvider {

	@Override
	protected String getDatabaseName() {
		return "listloader.db";
	}

	@Override
	protected int getDatabaseVersion() {
		return 1;
	}

	@Override
	protected void addTables(BaseLocator locator) {
		locator.putTable(new RssTable());
	}
}
