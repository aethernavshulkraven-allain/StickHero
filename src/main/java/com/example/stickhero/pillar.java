package com.example.stickhero;

public class pillar {
    private int height;
    private int width;
    private int xstart;

    @Override
    public String toString() {
        return "pillar{" +
                "height=" + height +
                ", width=" + width +
                ", xstart=" + xstart +
                '}';
    }

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
