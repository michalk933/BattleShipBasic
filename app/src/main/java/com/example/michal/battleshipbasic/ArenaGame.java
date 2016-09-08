package com.example.michal.battleshipbasic;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;


public class ArenaGame extends Activity {
    logicGame logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena_game);

        logic = new logicGame();

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
        Shut(view);
    }

    public void Shut(View view){
        ImageButton im = (ImageButton)findViewById(view.getId());
        String name = im.getResources().getResourceEntryName(view.getId());
        boolean hitOrMiss = logicGame.HitOsMiss(name);

        if(hitOrMiss == true){
            im.setImageResource(R.drawable.shipborder);
            Toast.makeText(getApplicationContext(), "YOU HIT", Toast.LENGTH_SHORT).show();
        }else if(hitOrMiss == false){
            im.setImageResource(R.drawable.miss);
            Toast.makeText(getApplicationContext(),"YOU MISS" ,Toast.LENGTH_SHORT).show();
        }
    }
}

