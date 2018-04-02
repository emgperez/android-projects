package com.example.android.musicalstructureapp;

/**
 * Created by emilio on 02/04/2018.
 */

public class Playlist {

    // Playlist name
    private String name;

    // Play mode
    private String playMode;


    public Playlist(String pName, String pMode)
    {
        name = pName;
        playMode = pMode;
    }

    /**
     * Get the name of the playlist
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the play  mode
     */
    public String getPlayMode()
    {
        return playMode;
    }

}
