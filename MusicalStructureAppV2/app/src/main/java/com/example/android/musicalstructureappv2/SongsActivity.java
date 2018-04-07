package com.example.android.musicalstructureappv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        // Navigation buttons
        Button artists = (Button) findViewById(R.id.artistsButton);
        Button playlists = (Button) findViewById(R.id.playlistsButton);


        // Set listeners for all buttons
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent = new Intent(SongsActivity.this, ArtistsActivity.class);
                startActivity(artistsIntent);
            }
        });

        // Set listeners for all buttons
        playlists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playlistsIntent = new Intent(SongsActivity.this, PlaylistsActivity.class);
                startActivity(playlistsIntent);
            }
        });

    }

}
