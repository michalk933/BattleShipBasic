package com.example.michal.battleshipbasic;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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

    public void clickMenu(View view) {
        switch (view.getId()){
            case R.id.oneUser:
                Toast.makeText(getApplicationContext(),"Jeden gracz",Toast.LENGTH_SHORT).show();
                break;
            case R.id.twoUser:
                Toast.makeText(getApplicationContext(),"dwoch graczy",Toast.LENGTH_SHORT).show();
                break;
            case R.id.newUse:
                Toast.makeText(getApplicationContext(),"nowyGracz",Toast.LENGTH_SHORT).show();
                break;
            case R.id.statistic:
                Toast.makeText(getApplicationContext(),"Statystyki",Toast.LENGTH_SHORT).show();
                break;




        }


    }
}
