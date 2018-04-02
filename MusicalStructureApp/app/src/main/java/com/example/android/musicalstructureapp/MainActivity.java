package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Toast.makeText(this , "OnCreate MainActivity 1", Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this , "OnCreate MainActivity 2", Toast.LENGTH_SHORT).show();

        // Find the view that shows the playlist category
        TextView pLists = (TextView)findViewById(R.id.playLists);

        Toast.makeText(this , "Found TextView list", Toast.LENGTH_SHORT).show();

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

    }

}
