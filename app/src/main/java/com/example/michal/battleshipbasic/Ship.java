package com.example.michal.battleshipbasic;

/**
 * Created by michal on 05.09.2016.
 */
public class Ship {
    private int size;
    private String[] location;
    private String[] hitShip;
    private int licznik = 1;

    Ship(int size, String[] location){
        this.size = size;
        this.location = location;
        hitShip = new String[size];
    }
    public int getSizeShip(){
        return size;
    }
    public String[] getLocationShip(){
        return this.location;
    }
    public boolean sethitShip(String locationHitShip) {

        if(licznik == this.size){
            return true;
        }else if(licznik != this.size) {
            hitShip[licznik] = locationHitShip;
            licznik++;
        }
        return false;
    }

    public boolean isfinish(){
        boolean flags = false;
        for(int i=0; i<=this.size;i++){
            if(location[i] == hitShip[i]){
                flags = true;
            }else flags = false;


        }
        return flags;
    }




}
