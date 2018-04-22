package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    // MediaPlayer object to play numbers audio files
    private MediaPlayer player;

    // Listener to get triggered when playing has ended
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // ArrayList of words
        final ArrayList<Word> words = new ArrayList<Word>();

        // Populate the ArrayList
        //words.add("one");
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo´e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na´aacha", R.drawable.number_ten, R.raw.number_ten));


        // ArrayAdapter to create a View for each element in the words list. Every item in the words list will have
        // a View in the 'listView' object
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

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

                // Release the player resources before playing a new sound
                releaseMediaPlayer();

                // Then create the player for that current word and its associated audio
                player = MediaPlayer.create(NumbersActivity.this, currentWord.getAudioResourceId());

                // And start the audio
                player.start();

                // Add callback method to release resources when the sound has finished playing
                player.setOnCompletionListener(completionListener);
            }
        });

    }

    /**
     * Clean up the media player by releasing its resources
     */
    private void releaseMediaPlayer()
    {
        // If the media player is not null, it may be still playing a sound
        if (player != null ) {
            // Release its resources
            player.release();
            player = null;
        }
    }

    /**
     * Clean up the resources (release) when stopping
     */
    @Override
    protected void onStop()
    {
        super.onStop();
        releaseMediaPlayer();
    }
}
