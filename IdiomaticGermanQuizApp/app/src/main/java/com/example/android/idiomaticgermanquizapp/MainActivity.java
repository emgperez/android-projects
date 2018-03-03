package com.example.android.idiomaticgermanquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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

        // Question number three
        RadioButton answerThree = (RadioButton)findViewById(R.id.choice_3_1);
        if (answerThree.isChecked())
            correctAnswers += 1;

        // Question number four
        RadioButton answerFour = (RadioButton)findViewById(R.id.choice_4_1);
        if (answerFour.isChecked())
            correctAnswers += 1;

        // Question number five
        RadioButton answerFive = (RadioButton)findViewById(R.id.choice_5_3);
        if (answerFive.isChecked())
            correctAnswers += 1;

        // Question number six
        RadioButton answerSix = (RadioButton)findViewById(R.id.choice_6_4);
        if (answerSix.isChecked())
            correctAnswers += 1;

        // Question number seven
        RadioButton answerSeven = (RadioButton)findViewById(R.id.choice_7_1);
        if (answerSeven.isChecked())
            correctAnswers += 1;

        // Question number eight
        RadioButton answerEight = (RadioButton)findViewById(R.id.choice_8_4);
        if (answerEight.isChecked())
            correctAnswers += 1;

        // Question number nine
        RadioButton answerNine = (RadioButton)findViewById(R.id.choice_9_2);
        if (answerNine.isChecked())
            correctAnswers += 1;

        // Question number ten
        RadioButton answerTen = (RadioButton)findViewById(R.id.choice_10_2);
        if (answerTen.isChecked())
            correctAnswers += 1;

        // Question number eleven (two answers needed)
        CheckBox answerEleven_1 = (CheckBox)findViewById(R.id.choice_11_2);
        CheckBox answerEleven_2 = (CheckBox)findViewById(R.id.choice_11_3);
        if (answerEleven_1.isChecked() && answerEleven_2.isChecked())
            correctAnswers += 1;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * It resets the counter that keeps your correct answers
     */
    private void resetAnswers(){
        correctAnswers = 0;
    }
}
