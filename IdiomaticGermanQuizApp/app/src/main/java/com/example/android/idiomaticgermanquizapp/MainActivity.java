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

    /**
     * Checks the number of correct answers depending on the choices you made
     * @param view
     */
    private void checkAnswers(View view) {

        // Get questions answers

        // Question number one
        RadioButton answerOne = (RadioButton)findViewById(R.id.choice_1_1);
        if (answerOne.isChecked())
            correctAnswers += 1;

        // Question number two
        RadioButton answerTwo = (RadioButton)findViewById(R.id.choice_2_2);
        if (answerTwo.isChecked())
            correctAnswers += 1;



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
