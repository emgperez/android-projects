package com.example.android.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate the TextViews in activity_main.xml
        // 1. Name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText("emgperez");

        // 2. Birthday
        TextView birthday = (TextView)findViewById(R.id.birthday);
        birthday.setText("10/20/1982");

        // 3. Country
        TextView country = (TextView)findViewById(R.id.country);
        country.setText("Spain");




    }
}
