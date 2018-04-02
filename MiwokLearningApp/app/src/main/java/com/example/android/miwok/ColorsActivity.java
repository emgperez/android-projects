package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        // ArrayList of words
        ArrayList<Word> words = new ArrayList<Word>();

        // Populate the ArrayList
        //words.add("one");
        words.add(new Word("red", "weṭeṭṭi"));
        words.add(new Word("green", "chokokki"));
        words.add(new Word("brown", "ṭakaakki"));
        words.add(new Word("gray", "ṭopoppi"));
        words.add(new Word("black", "kululli"));
        words.add(new Word("white", "kelelli"));
        words.add(new Word("dusty yellow", "ṭopiisә"));
        words.add(new Word("mustard yellow", "chiwiiṭә"));
       
        // ArrayAdapter to create a View for each element in the words list. Every item in the words list will have
        // a View in the 'listView' object
        WordAdapter adapter = new WordAdapter(this, words);

        // Find the ListView identified by 'list' in the layout
        ListView listView = (ListView) findViewById(R.id.list);

        // And set the adapter created before
        listView.setAdapter(adapter);
    }
}
