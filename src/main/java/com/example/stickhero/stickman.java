package com.example.stickhero;

public class stickman {
    public stick extendStick(){
        //extends stick of length equal to the time of hold of master key
        stick newstick = new stick();
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
