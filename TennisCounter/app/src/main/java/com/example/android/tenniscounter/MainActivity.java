package com.example.android.tenniscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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

    // Current set counter
    int currentSet = 1;

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

        // And now, take the score and print in on the layout
        switch (currentSet)
        {
            case 1:
                // Print status on set 1 view
                // displayStatus(playerOneScore, playerTwoScore, set = 1)
            case 2:
                // Print status on set 2 view
                // displayStatus(playerOneScore, playerTwoScore, set = 2)
            case 3:
                // Print status on set 3 view
                // displayStatus(playerOneScore, playerTwoScore, set = 3)
        }



    }


    /**
     * Displays the given score for Player One.
     */
    //public void displayStatus(int scoreOne, int scoreTwo, int setNumber) {
    //
    //    TextView scoreView = (TextView) findViewById(R.id.team_a_score);
    //    scoreView.setText(String.valueOf(score));
    //}

    /**
     * Displays the given score for Player Two.
     */
    //public void displayForTeamB(int score) {
    //    TextView scoreView = (TextView) findViewById(R.id.team_b_score);
    //    scoreView.setText(String.valueOf(score));
    //}



}
