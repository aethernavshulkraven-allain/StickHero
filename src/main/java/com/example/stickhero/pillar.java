package com.example.stickhero;

public class pillar implements gameObjects, collidable{
    private coordinates position;

    public coordinates getPosition() {
        return position;
    }

    public void setPosition(coordinates pillarPosition) {
        this.position = pillarPosition;
    }

    public pillar(coordinates pillarPosition, int height, int width, int xstart) {
        this.position = pillarPosition;
        this.height = height;
        this.width = width;
        this.xstart = xstart;
    }

    @Override
    public String toString() {
        return "pillar{" +
                "pillarPosition=" + position +
                ", height=" + height +
                ", width=" + width +
                ", xstart=" + xstart +
                '}';
    }

    private int height;
    private int width;
    private int xstart;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getXstart() {
        return xstart;
    }

    public void setXstart(int xstart) {
        this.xstart = xstart;
    }

    public pillar(int height, int width, int xstart) {
        this.height = height;
        this.width = width;
        this.xstart = xstart;
    }
}
