package com.example.stickhero;

public class coordinates {
    private int x;
    private int y;

    public coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
