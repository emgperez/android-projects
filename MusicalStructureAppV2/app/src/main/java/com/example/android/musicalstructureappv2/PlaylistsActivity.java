package com.example.android.musicalstructureappv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PlaylistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);

        // Navigation buttons
        Button songs = (Button)findViewById(R.id.songsButton);
        Button artists = (Button)findViewById(R.id.artistsButton);

        // Set listeners for all buttons
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songsIntent = new Intent(PlaylistsActivity.this, SongsActivity.class);
                startActivity(songsIntent);
            }
        });

        // Set listeners for all buttons
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent = new Intent(PlaylistsActivity.this, ArtistsActivity.class);
                startActivity(artistsIntent);
            }
        });




    }
}