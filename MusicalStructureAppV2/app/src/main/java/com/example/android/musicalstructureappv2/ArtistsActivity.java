package com.example.android.musicalstructureappv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        // Navigation buttons
        Button songs = (Button)findViewById(R.id.songsButton);
        Button playlists = (Button)findViewById(R.id.playlistsButton);

        // Set listeners for all buttons
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songsIntent = new Intent(ArtistsActivity.this, SongsActivity.class);
                startActivity(songsIntent);
            }
        });

        // Set listeners for all buttons
        playlists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistsIntent = new Intent(ArtistsActivity.this, PlaylistsActivity.class);
                startActivity(playlistsIntent);
            }
        });




    }
}
