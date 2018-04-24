package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    // MediaPlayer object to play numbers audio files
    private MediaPlayer player;

    // Listener to get triggered when playing has ended
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    // Audio focus handler
    private AudioManager audioManager;

    /**
     * This listener will be triggered whenever the audio focus changes
     */
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                // I lost audio focus for a moment but I can duck, so I'll pause the playing and reset playback to the start of the file
                player.pause();
                player.seekTo(0); // start
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN)
            {
                // Resume playback
                player.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS)
            {
                // I lost audio focus permanently, so I'll release the resources
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Initialize AudioManager to request audio focus
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        // ArrayList of words
        final ArrayList<Word> words = new ArrayList<Word>();

        // Populate the ArrayList
        //words.add("one");
        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));


        // ArrayAdapter to create a View for each element in the words list. Every item in the words list will have
        // a View in the 'listView' object
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

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

                // Request audio focus to play the file (streamtype STREAM_MUSIC, durationHint AUDIOFOCUS_GAIN_TRANSIENT)
                int result = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // If request has been granted, then play the audio

                    // Create the player for that current word and its associated audio
                    player = MediaPlayer.create(PhrasesActivity.this, currentWord.getAudioResourceId());

                    // And start the audio
                    player.start();

                    // Add callback method to release resources when the sound has finished playing
                    player.setOnCompletionListener(completionListener);
                }
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

            // Set the player to null (it's the same as telling the player is not ready to play a file at the moment)
            player = null;

            // And abandon the focus whether we have it or not
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
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
