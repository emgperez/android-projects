package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaylistsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);

        // ArrayList of words
        ArrayList<Playlist> pLists = new ArrayList<Playlist>();

        // Populate the ArrayList
        pLists.add(new Playlist(getString(R.string.playlist_one), getString(R.string.mode_two)));
        pLists.add(new Playlist(getString(R.string.playlist_two), getString(R.string.mode_one)));
        pLists.add(new Playlist(getString(R.string.playlist_three), getString(R.string.mode_two)));
        pLists.add(new Playlist(getString(R.string.playlist_four), getString(R.string.mode_two)));

        // ArrayAdapter to create a View for each element in the playlists list. Every item in the list will have
        // a View in the 'listView' object
        PlaylistAdapter adapter = new PlaylistAdapter(this, pLists);

        // Find the ListView identified by 'list' in the layout
        ListView listView = (ListView) findViewById(R.id.list);


        // And set the adapter created before
        listView.setAdapter(adapter);



    }
}
