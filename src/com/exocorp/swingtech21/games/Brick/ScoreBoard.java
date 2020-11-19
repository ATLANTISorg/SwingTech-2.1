package com.exocorp.swingtech21.games.Brick;

import java.util.Arrays;

public class ScoreBoard {
    private int[] scoreBoard = new int[5];
    private boolean once = true; // DON'T FORGET THIS
    public static boolean high = false; // DON'T FORGET THIS

    public void updateScore(int score){
        if(once){
            if(score > scoreBoard[0]) scoreBoard[0] = score; // Checks if the new score qualifies in top 5.
            if(score > scoreBoard[4]) high = true;
            sortScore(scoreBoard);

            once = false;
        }
    }

    public void sortScore(int[] scoreBoard){

    }

    public void showScoreBoard(int[] scoreBoard){
        System.out.println(Arrays.toString(scoreBoard));
    }

    //------------------------------------------------------------------------------------------------------------------

    public int[] getScoreBoard() {
        return scoreBoard;
    }
}
