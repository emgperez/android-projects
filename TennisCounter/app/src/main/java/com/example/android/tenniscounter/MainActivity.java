package com.example.android.tenniscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Scoring: 0 = 0, 1 = 15, 2 = 30, 3 = 40
    int playerOneScore = 0;
    int playerTwoScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Player 1 by 1 point, scoring being 0 = 0, 1 = 15, 2 = 30, 3 = 40
     */
    public void scorePlayerOne(View v) {

        playerOneScore += 1;
        //displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Player 21 by 1 point, scoring being 0 = 0, 1 = 15, 2 = 30, 3 = 40
     */
    public void scorePlayerTwo(View v) {

        playerTwoScore += 1;
        //displayForTeamA(scoreTeamA);
    }

}
