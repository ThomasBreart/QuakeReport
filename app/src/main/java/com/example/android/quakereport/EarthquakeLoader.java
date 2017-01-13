package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Plop on 13/01/2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    public EarthquakeLoader(Context context, String url) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @@Override
    public List<Earthquake> loadInBackground() {

    }
}
