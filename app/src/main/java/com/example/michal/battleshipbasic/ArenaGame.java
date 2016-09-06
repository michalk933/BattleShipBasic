package com.example.michal.battleshipbasic;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
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

        //losowanie();
        String[]locationShip = {losowanie(),losowanie(),losowanie()};
        ship = new Ship(3, locationShip);


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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void clickBorder(View view) {
        //int butonClick = view.getId();
        //String s = String.valueOf(butonClick);
        //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        //ImageButton im = (ImageButton)findViewById(butonClick);
        //im.setImageResource(R.drawable.test);
        //String s = im.getResources().getResourceEntryName(butonClick);;
        //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        aim(view);

    }

    public void aim(View view){
        ImageButton im = (ImageButton)findViewById(view.getId());
        String name = im.getResources().getResourceEntryName(view.getId());;
        hitOrMiss(name);
        if(ship.getLocationShip().equals(name)){
            im.setImageResource(R.drawable.test);
            Toast.makeText(getApplicationContext(),"YOU HIT",Toast.LENGTH_SHORT).show();
        }else if(!ship.getLocationShip().equals(name)){
            im.setImageResource(R.drawable.testdwa);
            Toast.makeText(getApplicationContext(),"YOU MISS" ,Toast.LENGTH_SHORT).show();
        }

    }

    public String losowanie(){
        Random rand = new Random();
        int rowLos = rand.nextInt(10-1+1)+1;
        int colLos = rand.nextInt(10-1+1)+1;;

        String colLosString = "";
        int licznik = 1;

        for(char r='a';r<'k';r++){
            if(colLos == licznik){
                colLosString = String.valueOf(r);
            }
            licznik++;
        }

        Toast.makeText(getApplicationContext(),colLosString +" / "+ String.valueOf(colLos)+ " | "+String.valueOf(rowLos) ,Toast.LENGTH_SHORT).show();
        return String.valueOf(colLosString) + String.valueOf(rowLos);


    }

    public boolean hitOrMiss(String position){
        for(int i=0 ; i<ship.getSizeShip() ; i++){
            if(position.equals(ship.getLocationShip()[i])){
                Toast.makeText(getApplicationContext(),"czy to to" +ship.getLocationShip()[i] ,Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }



}

