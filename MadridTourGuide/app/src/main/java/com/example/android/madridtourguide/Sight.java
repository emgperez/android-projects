package com.example.android.madridtourguide;

/**
 * A class to represent a sight in the city
 */
public class Sight {

    // Image resource
    private int mImageResourceId;

    // Name
    private int mName;

    // Location
    private int mLocation;

    // Closest underground station
    private int mMetroStation;

    // Closest bus stop
    private int mBusStop;

    public Sight(int imageResourceId, int location, int metroStation, int busStop, int name)
    {
        mImageResourceId = imageResourceId;
        mLocation = location;
        mMetroStation = metroStation;
        mBusStop = busStop;
        mName = name;
    }

    public int getImageResourceId(){ return mImageResourceId; }

    public int getLocation(){ return mLocation; }

    public int getMetroStation() { return mMetroStation; }

    public int getBusStop() { return mBusStop; }

    public int getName() { return mName; }
}