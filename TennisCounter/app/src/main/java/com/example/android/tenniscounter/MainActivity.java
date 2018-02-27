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

        // Always check game status when incrementing player score
        getScore();
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
                currentSet += 1;
            }
            else
            {
                playerOneGames += 1;
            }

        }
        else if((playerTwoScore > 3) && (Math.abs(playerTwoScore - playerOneScore) > 1))
        {
            // Player Two wins the game
            Toast.makeText(this ,"Game for player two: " + playerTwoScore, Toast.LENGTH_SHORT).show();

            // Reset score
            playerOneScore = 0;
            playerTwoScore = 0;

            // Add a game or set to player two depending on current score
            if((playerTwoGames >= 6) && (Math.abs(playerTwoGames - playerOneGames) > 1))
            {
                playerOneGames = 0;
                playerTwoGames = 0;
                playerTwoSets += 1;
                currentSet += 1;
            }
            else
            {
                playerTwoGames += 1;
            }
        }

        // And now, take the score and print it on the layout
        switch (currentSet)
        {
            case 1:
                // Print status on set 1 view
                displayStatus(playerOneScore, playerTwoScore, 1);
            case 2:
                // Print status on set 2 view
                displayStatus(playerOneScore, playerTwoScore, 2);
            case 3:
                // Print status on set 3 view
                displayStatus(playerOneScore, playerTwoScore, 3);
        }



    }


    /**
     * Displays the given score for Player One.
     */
    public void displayStatus(int scoreOne, int scoreTwo, int setNumber) {

        // First, reformat player score (0 = 0, 1 = 15, and so on)
        String scoreTextOne = reformatScore(scoreOne);
        String scoreTextTwo = reformatScore(scoreTwo);

        // Get all the views for both players and set the values
        switch(setNumber) {
            case 1:
                displaySetStatus(1);
                break;
            case 2:
                displaySetStatus(2);
                break;
            case 3:
                displaySetStatus(3);
                break;
        }

        // Display current score
        TextView playerOneCurrent = (TextView) findViewById(R.id.player_a_current);
        playerOneCurrent.setText(scoreTextOne);

        TextView playerTwoCurrent = (TextView) findViewById(R.id.player_b_current);
        playerOneCurrent.setText(scoreTextTwo);

    }

    public void displaySetStatus(int set)
    {
        switch (set){
            case 1:
                // Player One status
                TextView pOneSetOneView = (TextView) findViewById(R.id.player_a_set1_games);
                pOneSetOneView.setText(String.valueOf(playerOneGames));

                // Player Two status
                TextView pTwoSetOneView = (TextView) findViewById(R.id.player_b_set1_games);
                pTwoSetOneView.setText(String.valueOf(playerTwoGames));

                break;

            case 2:
                // Player One status
                TextView pOneSetTwoView = (TextView) findViewById(R.id.player_a_set2_games);
                pOneSetTwoView.setText(String.valueOf(playerOneGames));

                // Player Two status
                TextView pTwoSetTwoView = (TextView) findViewById(R.id.player_b_set2_games);
                pTwoSetTwoView.setText(String.valueOf(playerOneGames));

                break;

            case 3:

                if(playerOneSets == 2 || playerTwoSets == 2) {

                    Toast.makeText(this ,"Game already ended: " + playerOneGames + " " + playerTwoGames, Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    // Player One status
                    TextView pOneSetThreeView = (TextView) findViewById(R.id.player_a_set3_games);
                    pOneSetThreeView.setText(String.valueOf(playerOneGames));

                    // Player Two status
                    TextView pTwoSetThreeView = (TextView) findViewById(R.id.player_b_set3_games);
                    pTwoSetThreeView.setText(String.valueOf(playerOneGames));
                }

                break;
        }

    }

    private String reformatScore(int score)
    {
        String value = "";

        switch(score)
        {
            case 0:
                value = "0";
                break;
            case 1:
                value = "15";
                break;
            case 2:
                value = "30";
                break;
            case 3 :
                value = "40";
                break;
            case 4:
                value = "AD";
                break;
        }

        return value;
    }

    /**
     * Displays the given score for Player Two.
     */
    //public void displayForTeamB(int score) {
    //    TextView scoreView = (TextView) findViewById(R.id.team_b_score);
    //    scoreView.setText(String.valueOf(score));
    //}



}
