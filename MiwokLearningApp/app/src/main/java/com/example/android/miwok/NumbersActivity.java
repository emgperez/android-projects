package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
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

        // ArrayAdapter to create a View for each element in the words list. Every item in the words list will have
        // a View in the 'listView' object
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);

        // Find the ListView identified by 'list' in the layout
        //ListView listView = (ListView) findViewById(R.id.list);
        GridView gridView = (GridView)findViewById(R.id.list);

        // And set the adapter created before
        //listView.setAdapter(itemsAdapter);
        gridView.setAdapter(itemsAdapter);

    }
}
