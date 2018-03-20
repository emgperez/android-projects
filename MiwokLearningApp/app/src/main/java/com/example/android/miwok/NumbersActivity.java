package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // ArrayList of words
        ArrayList<String> words = new ArrayList<String>();

        // Populate the ArrayList
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        // Index to control the loop
        int wordIndex;

        for(wordIndex = 0; wordIndex < words.size(); wordIndex++)
        {
            // Create view for the element in the array
            TextView wordView = new TextView(this);
            wordView.setText(words.get(wordIndex));

            // Add child view to parent
            rootView.addView(wordView);
        }

    }
}
