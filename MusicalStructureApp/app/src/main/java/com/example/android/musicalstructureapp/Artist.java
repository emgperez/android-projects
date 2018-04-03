package com.example.android.musicalstructureapp;

/**
 * Created by emilio on 03/04/2018.
 */

public class Artist {

    // Artist name
    private String name;

    // Genre of music
    private String genre;

    public Artist(String aName, String aGenre)
    {
        name = aName;
        genre = aGenre;
    }

    /**
     * Get the name of the artist
     */
    public String getName(){ return name; }

    /**
     * Get the genre of the music
     */
    public String getGenre(){ return genre; }

}
