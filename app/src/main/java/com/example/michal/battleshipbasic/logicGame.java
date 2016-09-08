package com.example.michal.battleshipbasic;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by michal on 08.09.2016.
 */
public class logicGame {
    static ArenaGame a = new ArenaGame();
    static Ship[] lista = {new Ship(3, losowanie(3)),
                            new Ship(4, losowanie(4)),
                                    new Ship(5, losowanie(5))};


    public static boolean HitOsMiss(String location){
        for(int j =0; j<=2; j++) {
            for (int i = 0; i < lista[j].getSizeShip(); i++) {
                if (location.equals(lista[j].getLocationShip()[i])) {
                    lista[j].sethitShip(location);
                    //finish();
                    return true;
                }
            }
        }
       return false;
    }


    public static String[] losowanie(int sizeShip){

        Random rand = new Random();
        int orientation = rand.nextInt(2-1+1)+1;
        int col=0;
        int row=0;
        String kolekcja[] = new String[sizeShip];
        if(orientation == 1){
            col = rand.nextInt(10-1+1)+1;
            row = rand.nextInt((10-sizeShip)-1+1)+1;

            for(int i=0; i<sizeShip; i++){
                kolekcja[i] = String.valueOf(changeNumericAlphanumeric(col)) + String.valueOf(row++);
            }


        }else if(orientation == 2){
            col = rand.nextInt((10-sizeShip)-1+1)+1;
            row = rand.nextInt(10-1+1)+1;

            for(int i=0; i<sizeShip; i++){
                kolekcja[i] = String.valueOf(changeNumericAlphanumeric(col++)) + String.valueOf(row);
            }
        }

        return kolekcja;
    }


    //Methot changes number in alphanumeric
    public static String changeNumericAlphanumeric(int num){

        String colLosString = "";
        int licznik = 1;

        for(char r='a';r<'k';r++){
            if(num == licznik){
                colLosString = String.valueOf(r);
            }
            licznik++;
        }
        return colLosString;
    }

    public static boolean finish(){
        boolean finishOrNot = false;
        for(int i=0; i<2; i++){
            if(finishOrNot = lista[i].isfinish())finishOrNot = true;
        }
        return finishOrNot;
    }




}
