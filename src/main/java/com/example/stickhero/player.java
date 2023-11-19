package com.example.stickhero;

import java.util.ArrayList;

public class player {
    private score score;
    private int cherries;

    private ArrayList<cherry> listOfCherries = new ArrayList<cherry>();

    private stickman myAvatar;

    public stickman getMyAvatar() {
        return myAvatar;
    }

    private ArrayList<score> myScores = new ArrayList<score>();;

    public void setMyAvatar(stickman myAvatar) {
        this.myAvatar = myAvatar;
    }

    @Override
    public String toString() {
        return "player{" +
                "score=" + score +
                ", cherries=" + cherries +
                '}';
    }

    public score getScore() {
        return score;
    }

    public void setScore(score score) {
        this.score = score;
    }

    public int getCherries() {
        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }

    public player(score score, int cherries) {
        this.score = score;
        this.cherries = cherries;
        this.myAvatar = new stickman(new coordinates(0, 0));
    }

    public void revive(){
        //code for reviving the player
    }
}