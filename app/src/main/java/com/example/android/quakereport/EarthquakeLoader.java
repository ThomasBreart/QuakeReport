package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by Plop on 13/01/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        Log.v(LOG_TAG, "Here are the constructor of EarthquakeLoader !!!");
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.v(LOG_TAG, "Here are the onStartLoading !!!");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.v(LOG_TAG, "Here are the loadInBackground !!!");
        if (mUrl == null) {
            return null;
        }
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
