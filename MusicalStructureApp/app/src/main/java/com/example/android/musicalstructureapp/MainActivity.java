package com.example.android.musicalstructureapp;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import android.app.ActionBar;

import android.support.design.widget.TabLayout;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Find the view that shows the playlist category
        TextView pLists = (TextView)findViewById(R.id.playLists);

        // Set a click listener on that View
        pLists.setOnClickListener(new View.OnClickListener(){

            // The code in this method will be executed when the play lists View is clicked on
            @Override
            public void onClick(View view) {

                // Behaviour for when the event happens
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistsActivity.class);
                startActivity(playlistIntent);

            }
        });

        // Find the view that shows the song category
        TextView pSongs = (TextView)findViewById(R.id.songs);

        // Set a click listener on that View
        pSongs.setOnClickListener(new View.OnClickListener(){

            // The code in this method will be executed when the play lists View is clicked on
            @Override
            public void onClick(View view) {

                // Behaviour for when the event happens
                Intent playlistIntent = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(playlistIntent);

            }
        });


        // Find the view that shows the artist category
        TextView pArtists = (TextView)findViewById(R.id.artists);

        // Set a click listener on that View
        pArtists.setOnClickListener(new View.OnClickListener(){

            // The code in this method will be executed when the play lists View is clicked on
            @Override
            public void onClick(View view) {

                // Behaviour for when the event happens
                Intent playlistIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                startActivity(playlistIntent);

            }
        });
    }


}
