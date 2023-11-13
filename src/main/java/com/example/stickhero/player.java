package com.example.stickhero;

public class player {
    private int score;
    private int cherries;

    @Override
    public String toString() {
        return "player{" +
                "score=" + score +
                ", cherries=" + cherries +
                '}';
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCherries() {
        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }

    public player(int score, int cherries) {
        this.score = score;
        this.cherries = cherries;
    }

    public void revive(){
        //code for reviving the player
    }
}