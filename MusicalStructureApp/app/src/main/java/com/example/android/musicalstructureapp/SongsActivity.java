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


/**
 * Created by emilio on 03/04/2018.
 */

public class SongsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Toast.makeText(this , "OnCreate Playlist", Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);

        // ArrayList of words
        ArrayList<Song> songList = new ArrayList<Song>();

        // Populate the ArrayList
        songList.add(new Song("I want it all", "Queen", "The Miracle", R.drawable.queen));
        songList.add(new Song("24K Magic", "Bruno Mars", "24K Magic", R.drawable.bruno_mars));
        songList.add(new Song("Billie Jean", "Michael Jackson", "The Essential Michael Jackson", R.drawable.jacko));
        songList.add(new Song("Rolling in the deep", "Adele", "21", R.drawable.adele));

        // ArrayAdapter to create a View for each element in the songs list. Every item in the list will have
        // a View in the 'listView' object
        SongAdapter adapter = new SongAdapter(this, songList);

        // Find the ListView identified by 'list' in the layout
        ListView listView = (ListView) findViewById(R.id.list);

        // And set the adapter created before
        listView.setAdapter(adapter);

    }
}
