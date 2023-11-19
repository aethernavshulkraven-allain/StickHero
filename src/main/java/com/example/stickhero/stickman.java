package com.example.stickhero;

public class stickman implements gameObjects, collidable    {

    private stick avatarsStick;
    private coordinates position;

    public coordinates getPosition() {
        return position;
    }

    public void setPosition(coordinates position) {
        this.position = position;
    }

    public stickman(coordinates stickmanPosition) {
        this.position = stickmanPosition;
    }

    public stick extendStick(){
        //extends stick of length equal to the time of hold of master key
        stick newstick = new stick(new coordinates(0, 0), 0);
        return newstick;
    }

    public void invert(){
        //inverts to get cherry
        //here the direction of stickman is reversed
    }

    public boolean isStickValid(stick myStick, pillar currPillar, pillar nextPillar){
        //check weather the extended stick falls on the top of the next pillar
        if(myStick.getLength() == nextPillar.getXstart() - currPillar.getXstart() + currPillar.getWidth()) return true;
        else return false;
    }

    public void collectCherry(){
        //stickman collects cherries
    }
}
