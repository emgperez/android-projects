package com.example.android.tenniscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Scoring: 0 = 0, 1 = 15, 2 = 30, 3 = 40
    int playerOneScore = 0;
    int playerTwoScore = 0;

    // Number of won games by each player
    int playerOneGames = 0;
    int playerTwoGames = 0;

    // Number of won sets by each player
    int playerOneSets = 0;
    int playerTwoSets = 0;

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

        // Always check game status when incrementing player score
        getScore();
    }

    /**
     * Increase the score for Player 21 by 1 point, scoring being 0 = 0, 1 = 15, 2 = 30, 3 = 40
     */
    public void scorePlayerTwo(View v) {

        playerTwoScore += 1;
        //displayForTeamA(scoreTeamA);
    }

    public void getScore() {

        if((playerOneScore > 3) && (Math.abs(playerOneScore - playerTwoScore) > 1))
        {
            // Player One wins the game
            Toast.makeText(this ,"Game for player one: " + playerOneScore, Toast.LENGTH_SHORT).show();

            // Reset score
            playerOneScore = 0;
            playerTwoScore = 0;

            // Add a game or set to player one depending on current score
            if((playerOneGames >= 6) && (Math.abs(playerOneGames - playerTwoGames) > 1))
            {
                playerOneGames = 0;
                playerTwoGames = 0;
                playerOneSets += 1;
            }
            else
            {
                playerOneGames += 1;
            }

        }
        else if((playerTwoScore > 3) && (Math.abs(playerTwoScore - playerOneScore) > 1))
        {
            // Player One wins the game
            Toast.makeText(this ,"Game for player two: " + playerTwoScore, Toast.LENGTH_SHORT).show();

            // Reset score
            playerOneScore = 0;
            playerTwoScore = 0;

            // Add a game or set to player one depending on current score
            if((playerTwoGames >= 6) && (Math.abs(playerTwoGames - playerOneGames) > 1))
            {
                playerOneGames = 0;
                playerTwoGames = 0;
                playerTwoSets += 1;
            }
            else
            {
                playerTwoGames += 1;
            }
        }


    }



}
