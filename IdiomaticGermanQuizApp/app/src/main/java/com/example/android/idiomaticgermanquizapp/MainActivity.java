package com.example.android.idiomaticgermanquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Number of correct answers
    int correctAnswers;

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

        // Reset the counter before every submit
        correctAnswers = 0;
        checkAnswers(view);

        // Display number of correct answers
        Toast.makeText(this , getString(R.string.Result) + " " + correctAnswers, Toast.LENGTH_SHORT).show();

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
        RadioButton answerThree = (RadioButton)findViewById(R.id.choice_3_3);
        if (answerThree.isChecked())
            correctAnswers += 1;

        // Question number four
        RadioButton answerFour = (RadioButton)findViewById(R.id.choice_4_4);
        if (answerFour.isChecked())
            correctAnswers += 1;

        // Question number five
        RadioButton answerFive = (RadioButton)findViewById(R.id.choice_5_1);
        if (answerFive.isChecked())
            correctAnswers += 1;

        // Question number six
        RadioButton answerSix = (RadioButton)findViewById(R.id.choice_6_4);
        if (answerSix.isChecked())
            correctAnswers += 1;

        // Question number seven
        RadioButton answerSeven = (RadioButton)findViewById(R.id.choice_7_2);
        if (answerSeven.isChecked())
            correctAnswers += 1;

        // Question number eight
        RadioButton answerEight = (RadioButton)findViewById(R.id.choice_8_2);
        if (answerEight.isChecked())
            correctAnswers += 1;

        // Question number nine (two answers needed)
        CheckBox answerNine_1 = (CheckBox)findViewById(R.id.choice_9_1);
        CheckBox answerNine_2 = (CheckBox)findViewById(R.id.choice_9_2);
        CheckBox answerNine_3 = (CheckBox)findViewById(R.id.choice_9_3);
        CheckBox answerNine_4 = (CheckBox)findViewById(R.id.choice_9_4);

        if (answerNine_2.isChecked() && answerNine_3.isChecked()) {

            // Verify that only the correct answers are checked
            if(!answerNine_1.isChecked() && !answerNine_4.isChecked())
                correctAnswers += 1;
        }

        // Question number ten (text input)
        EditText answerTen = (EditText)findViewById(R.id.question10Input);
        String value = answerTen.getText().toString();
        if(value.equalsIgnoreCase(getString(R.string.ans_10)))
            correctAnswers += 1;
    }

    /**
     * It resets the counter that keeps your correct answers
     */
    public void resetAnswers(View view){

        correctAnswers = 0;
        Toast.makeText(this , R.string.Reset, Toast.LENGTH_SHORT).show();

        // Uncheck all the answers
        RadioGroup questionOne = (RadioGroup)findViewById(R.id.questionOne);
        questionOne.clearCheck();

        RadioGroup questionTwo = (RadioGroup)findViewById(R.id.questionTwo);
        questionTwo.clearCheck();

        RadioGroup questionThree = (RadioGroup)findViewById(R.id.questionThree);
        questionThree.clearCheck();

        RadioGroup questionFour = (RadioGroup)findViewById(R.id.questionFour);
        questionFour.clearCheck();

        RadioGroup questionFive = (RadioGroup)findViewById(R.id.questionFive);
        questionFive.clearCheck();

        RadioGroup questionSix = (RadioGroup)findViewById(R.id.questionSix);
        questionSix.clearCheck();

        RadioGroup questionSeven = (RadioGroup)findViewById(R.id.questionSeven);
        questionSeven.clearCheck();

        RadioGroup questionEight = (RadioGroup)findViewById(R.id.questionEight);
        questionEight.clearCheck();

        CheckBox questionEleven_1 = (CheckBox)findViewById(R.id.choice_9_1);
        questionEleven_1.setChecked(false);

        CheckBox questionEleven_2 = (CheckBox)findViewById(R.id.choice_9_2);
        questionEleven_2.setChecked(false);

        CheckBox questionEleven_3 = (CheckBox)findViewById(R.id.choice_9_3);
        questionEleven_3.setChecked(false);

        CheckBox questionEleven_4 = (CheckBox)findViewById(R.id.choice_9_4);
        questionEleven_4.setChecked(false);

        EditText questionTwelve = (EditText)findViewById(R.id.question10Input);
        questionTwelve.setText("");

    }
}
