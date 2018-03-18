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

        // Create view for the first element in the array
        TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        // Add child view to parent
        rootView.addView(wordView);

        // Create view for the second element in the array
        TextView wordView2 = new TextView(this);
        wordView2.setText(words.get(1));
        // Add child view to parent
        rootView.addView(wordView2);

        // Create view for the third element in the array
        TextView wordView3 = new TextView(this);
        wordView3.setText(words.get(2));
        // Add child view to parent
        rootView.addView(wordView3);
    }
}
