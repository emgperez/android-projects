package com.example.android.friendstvshow_basicquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Number of correct answers
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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

        // Question number seven
        RadioButton answerSeven = (RadioButton)findViewById(R.id.choice_7_1);
        if (answerSeven.isChecked())
            correctAnswers += 1;

        // Question number eight
        RadioButton answerEight = (RadioButton)findViewById(R.id.choice_8_2);
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

        // Question number eleven
        RadioButton answerEleven = (RadioButton)findViewById(R.id.choice_11_3);
        if (answerEleven.isChecked())
            correctAnswers += 1;

        // Question number twelve
        RadioButton answerTwelve = (RadioButton)findViewById(R.id.choice_12_2);
        if (answerTwelve.isChecked())
            correctAnswers += 1;



    }

    /**
     * It resets the counter that keeps your correct answers
     */
    public void resetAnswers(View view){

        correctAnswers = 0;
    }
}
