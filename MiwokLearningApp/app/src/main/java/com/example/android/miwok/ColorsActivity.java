package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    // MediaPlayer object to play numbers audio files
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // ArrayList of words
        final ArrayList<Word> words = new ArrayList<Word>();

        // Populate the ArrayList
        //words.add("one");
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        // ArrayAdapter to create a View for each element in the words list. Every item in the words list will have
        // a View in the 'listView' object
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        // Find the ListView identified by 'list' in the layout
        ListView listView = (ListView) findViewById(R.id.list);

        // And set the adapter created before
        listView.setAdapter(adapter);

        // Set a listener so that audio is played when clicking on any item of the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // First, get the Word object on the i-position of the adapter
                Word currentWord = words.get(i);

                // Then create the player for that current word and its associated audio
                player = MediaPlayer.create(ColorsActivity.this, currentWord.getAudioResourceId());

                // And start the audio
                player.start();
            }
        });
    }
}
