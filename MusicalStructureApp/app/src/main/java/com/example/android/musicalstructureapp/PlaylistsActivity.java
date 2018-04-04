package com.example.android.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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
        pLists.add(new Playlist("Weird music", "Repeat"));
        pLists.add(new Playlist("Uplifting music", "Shuffle"));
        pLists.add(new Playlist("Italo Disco", "Repeat"));
        pLists.add(new Playlist("Spanish Copla", "Repeat"));

        // ArrayAdapter to create a View for each element in the playlists list. Every item in the list will have
        // a View in the 'listView' object
        PlaylistAdapter adapter = new PlaylistAdapter(this, pLists);

        // Find the ListView identified by 'list' in the layout
        ListView listView = (ListView) findViewById(R.id.list);

        // And set the adapter created before
        listView.setAdapter(adapter);

    }
}
