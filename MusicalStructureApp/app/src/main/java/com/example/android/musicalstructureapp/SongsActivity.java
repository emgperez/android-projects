package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;


public class SongsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        // ArrayList of words
        ArrayList<Song> songList = new ArrayList<Song>();

        // Populate the ArrayList
        songList.add(new Song(getString(R.string.song_one), getString(R.string.artist_one), getString(R.string.album_one), R.mipmap.ic_queen));
        songList.add(new Song(getString(R.string.song_two), getString(R.string.artist_two), getString(R.string.album_two), R.mipmap.ic_bruno_mars));
        songList.add(new Song(getString(R.string.song_three), getString(R.string.artist_three), getString(R.string.album_three), R.mipmap.ic_jacko));
        songList.add(new Song(getString(R.string.song_four), getString(R.string.artist_four), getString(R.string.album_four), R.mipmap.ic_adele));

        // ArrayAdapter to create a View for each element in the songs list. Every item in the list will have
        // a View in the 'listView' object
        SongAdapter adapter = new SongAdapter(this, songList);

        // Find the ListView identified by 'list' in the layout
        ListView listView = (ListView) findViewById(R.id.list);

        // And set the adapter created before
        listView.setAdapter(adapter);

    }
}
