package com.example.stickhero;

public class gameOverMenu implements menu{
    private score score;
    private score bestScore;

    private homeButton goHomeButton;
    private restartButton restartButton;

    private leaderbrdButton leaderbrdButton;

    public void viewLeaderboard() {
        //called by leaderbrdButton
    }

    @Override
    public void exitMenu() {

    }
}
