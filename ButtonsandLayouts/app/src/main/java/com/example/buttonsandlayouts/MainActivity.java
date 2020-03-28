package com.example.buttonsandlayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "You clicked on Floating Button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
        public void showLinear(View view){
                Intent intent = new Intent(MainActivity.this, LinearActivity.class);
                startActivity(intent);
            }

        public void showFrame(View view) {
            Intent intent = new Intent(MainActivity.this, FrameActivity.class);
            startActivity(intent);
        }

        public void showRelative(View view){
                Intent intent = new Intent(MainActivity.this, RelativeActivity.class);
                startActivity(intent);
            }

        public void showTable(View view){
                Intent intent = new Intent(MainActivity.this, TableActivity.class);
                startActivity(intent);
            }
}
