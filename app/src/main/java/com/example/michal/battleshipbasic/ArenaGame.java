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

    String obiekt = "a3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena_game);
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
        test(view);

    }

    public void test(View view){
        ImageButton im = (ImageButton)findViewById(view.getId());
        String name = im.getResources().getResourceEntryName(view.getId());;
        if(obiekt.equals(name)){
            im.setImageResource(R.drawable.test);
            Toast.makeText(getApplicationContext(),"YOU HIT",Toast.LENGTH_SHORT).show();
        }else if(!obiekt.equals(name)){
            im.setImageResource(R.drawable.testdwa);
            //Toast.makeText(getApplicationContext(),"YOU MISS" ,Toast.LENGTH_SHORT).show();
        }

    }

    public void losowanie(){
        int rowLos;
        int colLos;
        Random rand = new Random();
        rowLos = rand.nextInt(11);
        colLos = rand.nextInt(11);
        String kur = "";
        for(char r='a';r<'j';r++){
            if(kur = r[rowLos];){

            }

        }
        Toast.makeText(getApplicationContext(),kur ,Toast.LENGTH_SHORT).show();



    }


}

