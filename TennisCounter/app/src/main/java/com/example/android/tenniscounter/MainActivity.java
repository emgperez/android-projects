package com.example.android.tenniscounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Scoring: 0 = 0, 1 = 15, 2 = 30, 3 = 40
    int playerOneScore;
    int playerTwoScore;

    // Number of won games by each player
    int playerOneGames;
    int playerTwoGames;

    // Number of won sets by each player
    int playerOneSets;
    int playerTwoSets;

    // Current set counter
    int currentSet = 1;

    // Control new set
    boolean newSet = false;

    // Control match state
    boolean matchEnded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increases the score for Player 1 by 1 point, score being 0 = 0, 1 = 15, 2 = 30, 3 = 40
     */
    public void scorePlayerOne(View v) {

        if(playerTwoScore == 4 && playerOneScore == 3) {
            playerTwoScore -= 1;
        }
        else {
            playerOneScore += 1;
        }

        // Always check game status when incrementing player score
        getScore();
    }

    /**
     * Increases the score for Player 2 by 1 point, score being 0 = 0, 1 = 15, 2 = 30, 3 = 40
     */
    public void scorePlayerTwo(View v) {

        if(playerOneScore == 4 && playerTwoScore == 3)
        {
            playerOneScore -= 1;
        }
        else {
            playerTwoScore += 1;
        }

        // Always check game status when incrementing player score
        getScore();
    }

    /**
     * Checks the current state of the scoring and triggers its printing on the different Views
     */
    public void getScore() {

        if(newSet)
            newSet = false;

        if((playerOneScore > 3) && (Math.abs(playerOneScore - playerTwoScore) >= 1))
        {
            // Player One wins the game

            if(playerOneScore == 4 && playerTwoScore == 3)
            {
                // Advantage, don't end game
                displayStatus(playerOneScore, playerTwoScore, currentSet);
            }
            else {
                // Reset score
                playerOneScore = 0;
                playerTwoScore = 0;

                // Add a game or set to player one depending on current score
                if ((playerOneGames >= 5) && (Math.abs(playerOneGames - playerTwoGames) >= 1)) {
                    playerOneGames += 1;
                    playerOneSets += 1;
                    newSet = true;
                    Toast.makeText(this, R.string.setPlayerOne, Toast.LENGTH_SHORT).show();
                    displayStatus(playerOneScore, playerTwoScore, currentSet);

                    // Once the status is displayed, reset game counters
                    currentSet += 1;
                    playerOneGames = 0;
                    playerTwoGames = 0;

                } else {
                    playerOneGames += 1;
                }
            }

        }
        else if((playerTwoScore > 3) && (Math.abs(playerTwoScore - playerOneScore) >= 1))
        {
            // Player Two wins the game

            if(playerTwoScore == 4 && playerOneScore == 3)
            {
                // Advantage, don't end game
                displayStatus(playerOneScore, playerTwoScore, currentSet);
            }
            else {
                // Reset score
                playerOneScore = 0;
                playerTwoScore = 0;

                // Add a game or set to player two depending on current score
                if ((playerTwoGames >= 5) && (Math.abs(playerTwoGames - playerOneGames) >= 1)) {
                    playerTwoGames += 1;
                    playerTwoSets += 1;
                    newSet = true;
                    Toast.makeText(this, R.string.setPlayerTwo, Toast.LENGTH_SHORT).show();
                    displayStatus(playerOneScore, playerTwoScore, currentSet);

                    // Once the status is displayed, reset game counters
                    currentSet += 1;
                    playerOneGames = 0;
                    playerTwoGames = 0;

                } else {
                    playerTwoGames += 1;
                }
            }
        }

        // And now, take the score and print it on the layout
        if(!newSet)
            displayStatus(playerOneScore, playerTwoScore, currentSet);

    }

    /**
     * Displays the given score for both Player One and Player Two.
     * @param scoreOne Score por player one
     * @param scoreTwo Score for player two
     */
    public void displayStatus(int scoreOne, int scoreTwo, int setNumber) {

        // First, reformat player score (0 = 0, 1 = 15, and so on)
        String scoreTextOne = reformatScore(scoreOne);
        String scoreTextTwo = reformatScore(scoreTwo);

        if (setNumber >= 2 && !matchEnded) {
            // Check number of won sets
            if (playerOneSets == 2) {

                Toast.makeText(this, R.string.matchPlayerOne, Toast.LENGTH_SHORT).show();
                displaySetStatus(setNumber);
                matchEnded = true;
            } else if (playerTwoSets == 2) {
                Toast.makeText(this, R.string.matchPlayerTwo, Toast.LENGTH_SHORT).show();
                displaySetStatus(setNumber);
                matchEnded = true;
            }
        }

        // Get all the views for both players and set the values
        if (!matchEnded)
        {
            displayCurrent(scoreTextOne, scoreTextTwo);
            displaySetStatus(setNumber);
        }
        else
        {
            // Match ended, but reset current values
            displayCurrent("0 ", "0");
            String matchStatusMessage = getString(R.string.matchEnded) + " - " + getString(R.string.playerOne) + " " + playerOneSets + " " + getString(R.string.playerTwo) + " " + playerTwoSets;
            Toast.makeText(this , matchStatusMessage, Toast.LENGTH_SHORT).show();

        }
    }

    /**
     * Displays the status of the set (games for player one and games for player two)
     * @param set Number of current set (1 = first, 2 = second , 3 = third)
     */
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
                pTwoSetTwoView.setText(String.valueOf(playerTwoGames));

                break;

            case 3:
                // Player One status
                TextView pOneSetThreeView = (TextView) findViewById(R.id.player_a_set3_games);
                pOneSetThreeView.setText(String.valueOf(playerOneGames));

                // Player Two status
                TextView pTwoSetThreeView = (TextView) findViewById(R.id.player_b_set3_games);
                pTwoSetThreeView.setText(String.valueOf(playerTwoGames));

                break;
        }

    }

    /**
     * Given the score in an int variable, it reformats it to a String so that it can be properly displayed
     * @param score Numeric value representing the score (0 = 0, 1 = 15, 2 = 30, 3 = 40, 4 = AD)
     * @return
     */
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
     * Resets all the variables and views the game is comprised of
     * @param v Current View
     */
    public void resetScore(View v) {

        // Reset all views and counters

        // Counters
        playerOneScore = 0;
        playerTwoScore = 0;
        playerOneGames = 0;
        playerTwoGames = 0;
        playerOneSets = 0;
        playerTwoSets = 0;
        currentSet = 1;

        // Control variables
        matchEnded = false;

        // Current Score
        TextView playerOneCurrent = (TextView) findViewById(R.id.player_a_current);
        playerOneCurrent.setText("0");

        TextView playerTwoCurrent = (TextView) findViewById(R.id.player_b_current);
        playerTwoCurrent.setText("0");

        // Games in all sets
        TextView pOneSetOneView = (TextView) findViewById(R.id.player_a_set1_games);
        pOneSetOneView.setText(String.valueOf(playerOneGames));

        TextView pTwoSetOneView = (TextView) findViewById(R.id.player_b_set1_games);
        pTwoSetOneView.setText(String.valueOf(playerTwoGames));

        TextView pOneSetTwoView = (TextView) findViewById(R.id.player_a_set2_games);
        pOneSetTwoView.setText(String.valueOf(playerOneGames));

        TextView pTwoSetTwoView = (TextView) findViewById(R.id.player_b_set2_games);
        pTwoSetTwoView.setText(String.valueOf(playerTwoGames));

        TextView pOneSetThreeView = (TextView) findViewById(R.id.player_a_set3_games);
        pOneSetThreeView.setText(String.valueOf(playerOneGames));

        TextView pTwoSetThreeView = (TextView) findViewById(R.id.player_b_set3_games);
        pTwoSetThreeView.setText(String.valueOf(playerTwoGames));

    }

    /**
     * Displays score for current game
     * @param textA Score for player one
     * @param textB Score for player two
     */
    private void displayCurrent(String textA, String textB)
    {
        // Display current score
        TextView playerOneCurrent = (TextView) findViewById(R.id.player_a_current);
        playerOneCurrent.setText(textA);

        TextView playerTwoCurrent = (TextView) findViewById(R.id.player_b_current);
        playerTwoCurrent.setText(textB);
    }
}
