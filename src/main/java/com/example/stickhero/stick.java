package com.example.stickhero;

public class stick implements gameObjects, collidable{
    private coordinates position;

    public coordinates getPosition() {
        return position;
    }

    public void setPosition(coordinates position) {
        this.position = position;
    }

    public stick(coordinates position, int length) {
        this.position = position;
        this.length = length;
    }

    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
