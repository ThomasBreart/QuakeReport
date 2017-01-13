package com.example.android.quakereport;

/**
 * Created by Plop on 10/01/2017.
 */

public class Earthquake {

    private String mPlace;
    private double mMagnitude;
    private long mTimeInMilliseconds;
    private String mUrl;

    public Earthquake(String place, double magnitude, long timeInMilliseconds, String url) {
        mPlace = place;
        mMagnitude = magnitude;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;

    }

    public String getmPlace() {
        return mPlace;
    }
    public double getmMagnitude() {
        return mMagnitude;
    }
    public long getmTimeInMilliseconds() {
        return  mTimeInMilliseconds;
    }
    public String getmUrl() {return  mUrl;}

    @Override
    public String toString() {
        return mPlace;
    }
}
