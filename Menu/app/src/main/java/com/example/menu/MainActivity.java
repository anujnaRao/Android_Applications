package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuselect,menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        ConstraintLayout cl= findViewById(R.id.Clayout);

        switch(menuItem.getItemId())
        {
            case R.id.red:
                cl.setBackgroundColor(Color.RED);
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.peach:
                 cl.setBackgroundColor(Color.GRAY);
                 return true;
            case R.id.brown:
                 cl.setBackgroundColor(Color.GREEN);
                 break;
            case R.id.black:
                cl.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.blue:
                cl.setBackgroundColor(Color.BLUE);
                return true;
                default:
                    super.onOptionsItemSelected(menuItem);
        }
        return false;
    }
}
