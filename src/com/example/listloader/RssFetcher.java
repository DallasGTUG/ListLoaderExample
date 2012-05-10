package com.example.listloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.xml.sax.SAXException;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;
import android.util.Xml.Encoding;

public class RssFetcher {
	
    public static void fetch(ContentResolver resolver) 
    throws IOException, SAXException {
    	URL url = new URL("http://www.npr.org/rss/rss.php?id=1001");
    	final ValueCollection items = new ValueCollection(); 
    	InputStream stream = (InputStream) url.getContent();
    	RootElement root = new RootElement("rss");
    	
    	root.getChild("channel").getChild("item").setEndElementListener(new EndElementListener() {
			@Override
			public void end() {
				items.rows.add(items.currentRow);
				items.currentRow = new ContentValues();
			}
		});
       	root.getChild("channel").getChild("item").getChild("title").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				items.currentRow.put("title", body);
			}
		});
       	root.getChild("channel").getChild("item").getChild("description").setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				items.currentRow.put("description", body);
			}
		});
       	
       	Xml.parse(stream, Encoding.UTF_8, root.getContentHandler());
       	resolver.bulkInsert(DataContract.RSS_CONTENT_URI, items.getRows());
       	resolver.notifyChange(DataContract.RSS_CONTENT_URI, null);
    }
    
	public static void tryFetch(ContentResolver resolver)
	{
		try {
			fetch(resolver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
