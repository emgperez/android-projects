package com.example.android.idiomaticgermanquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Number of correct answers
    int correctAnswers = 0;

    /**
     * This methods triggers the checking of your quiz answers
     * @param view
     */
    public void submitQuestions(View view) {

        checkAnswers(view);

        Toast.makeText(this ,"Correct Answers: " + correctAnswers, Toast.LENGTH_SHORT).show();
        resetAnswers();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
