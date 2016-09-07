package com.example.michal.battleshipbasic;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;


public class ArenaGame extends Activity {


    Ship ship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena_game);


        String[]locationShip = losowanie(3);
        ship = new Ship(3, locationShip);

        String[]locationShipDwa = losowanie(5);
        ship = new Ship(5, locationShipDwa);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_arena_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    // OnClick
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void clickBorder(View view) {
        aim(view);
    }

    // This method gives information about the shot
    ////Is it aim in obiective
    public void aim(View view){
        ImageButton im = (ImageButton)findViewById(view.getId());
        String name = im.getResources().getResourceEntryName(view.getId());;

        if(hitOrMiss(name) == true){
            if(ship.sethitShip(name))Toast.makeText(getApplicationContext(),"Zniszczyles statek",Toast.LENGTH_SHORT).show();
            im.setImageResource(R.drawable.shipborder);
            Toast.makeText(getApplicationContext(),"YOU HIT",Toast.LENGTH_SHORT).show();
        }else if(hitOrMiss(name) == false){
            im.setImageResource(R.drawable.miss);
            Toast.makeText(getApplicationContext(),"YOU MISS" ,Toast.LENGTH_SHORT).show();
        }

    }

    //Methods random location for ship
    ////
    public String[] losowanie(int sizeShip){

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
                Toast.makeText(getApplicationContext(),kolekcja[i],Toast.LENGTH_SHORT).show();
            }


        }else if(orientation == 2){
            col = rand.nextInt((10-sizeShip)-1+1)+1;
            row = rand.nextInt(10-1+1)+1;

            for(int i=0; i<sizeShip; i++){
                kolekcja[i] = String.valueOf(changeNumericAlphanumeric(col++)) + String.valueOf(row);
                Toast.makeText(getApplicationContext(),kolekcja[i],Toast.LENGTH_SHORT).show();
            }
        }

        return kolekcja;
    }


    //HIT or MISS
    public boolean hitOrMiss(String position){
        for(int i=0 ; i<ship.getSizeShip() ; i++){
            if(position.equals(ship.getLocationShip()[i])){
                //Toast.makeText(getApplicationContext(),"czy to to" +ship.getLocationShip()[i] ,Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }


    //Methot changes number in alphanumeric
    public String changeNumericAlphanumeric(int num){

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


}

