package com.example.listloader;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RssFragment extends ListFragment implements LoaderCallbacks<Cursor> {

    private CursorAdapter adapter;

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState); 
        setEmptyText("No items");
        adapter = new MyAdapter(getActivity(), null, true);
        setListAdapter(adapter);
        getLoaderManager().initLoader(0, null, this);
    }
    
    public class MyAdapter extends CursorAdapter {

		public MyAdapter(Context context, Cursor c, boolean autoRequery) {
			super(context, c, autoRequery);
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			TextView tv1 = (TextView) view.getTag(R.id.text1);
			TextView tv2 = (TextView) view.getTag(R.id.text2);
			tv1.setText(cursor.getString(1));
			tv2.setText(cursor.getString(2));
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup viewgroup) {
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(R.layout.item, null);
			view.setTag(R.id.text1, view.findViewById(R.id.text1));
			view.setTag(R.id.text2, view.findViewById(R.id.text2));
			return view;
		}
	};
    

    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
        		getActivity(), 
        		DataContract.RSS_CONTENT_URI,
                DataContract.ALL_COLUMNS, 
                null, 
                null,
                null);
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
    	data.setNotificationUri(getActivity().getContentResolver(), DataContract.RSS_CONTENT_URI);
    	adapter.swapCursor(data);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    	adapter.swapCursor(null);
    }

}
