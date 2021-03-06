package com.example.android.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);

        // ArrayList of words
        ArrayList<Artist> pArtists = new ArrayList<Artist>();



        // Populate the ArrayList
        pArtists.add(new Artist(getString(R.string.artist_four), getString(R.string.genre_three)));
        pArtists.add(new Artist(getString(R.string.artist_two), getString(R.string.genre_two)));
        pArtists.add(new Artist(getString(R.string.artist_three), getString(R.string.genre_two)));
        pArtists.add(new Artist(getString(R.string.artist_one), getString(R.string.genre_one)));;

        // ArrayAdapter to create a View for each element in the artists list. Every item in the list will have
        // a View in the 'listView' object
        ArtistAdapter adapter = new ArtistAdapter(this, pArtists);

        // Find the ListView identified by 'list' in the layout
        ListView listView = (ListView) findViewById(R.id.list);

        // And set the adapter created before
        listView.setAdapter(adapter);

    }
}