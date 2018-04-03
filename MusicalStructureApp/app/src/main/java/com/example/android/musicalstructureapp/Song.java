package com.example.android.musicalstructureapp;

/**
 * Created by emilio on 03/04/2018.
 */

public class Song {

    // Song name
    private String name;

    // Artist
    private String artistName;

    // Drawable resource ID
    private int imageResourceId;


    public Song(String sName, String sArtist, int mImageResourceId)
    {
        name = sName;
        artistName = sArtist;
        imageResourceId = mImageResourceId;
    }

    /**
     * Get the name of the song
     */
    public String getName(){ return name; }

    /**
     * Get the artist name
     */
    public String getArtistName(){ return artistName; }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId(){ return imageResourceId; }
}
