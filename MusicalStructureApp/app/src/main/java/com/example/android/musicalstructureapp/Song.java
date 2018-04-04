package com.example.android.musicalstructureapp;

public class Song {

    // Song name
    private String name;

    // Artist
    private String artistName;

    // Album
    private String albumName;

    // Drawable resource ID
    private int imageResourceId;


    public Song(String sName, String sArtist, String sAlbum, int mImageResourceId)
    {
        name = sName;
        artistName = sArtist;
        albumName = sAlbum;
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
     * Get the album name
     */
    public String getAlbumName(){ return albumName; }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId(){ return imageResourceId; }
}
