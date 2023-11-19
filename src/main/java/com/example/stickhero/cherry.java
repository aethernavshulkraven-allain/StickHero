package com.example.stickhero;

public class cherry implements gameObjects, collidable, reward {
    private coordinates position;

    public coordinates getPosition() {
        return position;
    }

    public void setPosition(coordinates cherryPosition) {
        this.position = cherryPosition;
    }

    public cherry(coordinates cherryPosition) {
        this.position = cherryPosition;
    }

    @Override
    public void increment() {
        //
    }

    @Override
    public void decrement() {
        //
    }
}
