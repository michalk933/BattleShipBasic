package com.example.michal.battleshipbasic;

/**
 * Created by michal on 05.09.2016.
 */
public class Ship {
    private int size = 3;
    private String[] location;

    Ship(int size, String[] location){
        this.size = size;
        this.location = location;

    }
    public int getSizeShip(){
        return size;
    }
    public String[] getLocationShip(){
        return this.location;
    }



}
