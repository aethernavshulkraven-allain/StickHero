package com.example.stickhero;

public class player {
    private int score;
    private int cherries;

    private stickman myAvatar;

    public stickman getMyAvatar() {
        return myAvatar;
    }

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
        this.myAvatar = new stickman();
    }

    public void revive(){
        //code for reviving the player
    }
}