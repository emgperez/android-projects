package com.example.android.friendstvshow_basicquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void checkAnswers(View view) {

        // Get questions answers

        // Question number one
        RadioButton answerOne = (RadioButton)findViewById(R.id.choice_1_1);
        if (answerOne.isChecked())
            correctAnswers += 1;

        // Question number two
        RadioButton answerTwo = (RadioButton)findViewById(R.id.choice_2_3);
        if (answerTwo.isChecked())
            correctAnswers += 1;

        // Question number three
        RadioButton answerThree = (RadioButton)findViewById(R.id.choice_3_2);
        if (answerThree.isChecked())
            correctAnswers += 1;

        // Question number four
        RadioButton answerFour = (RadioButton)findViewById(R.id.choice_4_1);
        if (answerFour.isChecked())
            correctAnswers += 1;

        // Question number five
        RadioButton answerFive = (RadioButton)findViewById(R.id.choice_5_1);
        if (answerFive.isChecked())
            correctAnswers += 1;

        // Question number six
        RadioButton answerSix = (RadioButton)findViewById(R.id.choice_6_2);
        if (answerSix.isChecked())
            correctAnswers += 1;



    }
}
