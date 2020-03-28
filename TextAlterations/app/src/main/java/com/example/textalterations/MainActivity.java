package com.example.textalterations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnItalic,btnBold,btnEnter;
    EditText input;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.txt1);
        btnItalic = findViewById(R.id.italicB);
        btnBold = findViewById(R.id.boldB);
        btnEnter = findViewById(R.id.enter);
        rl = findViewById(R.id.rLayout);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter text to continue", Toast.LENGTH_SHORT).show();
                    input.setFocusable(true);
                }
                else{
                    String text = input.getText().toString();
                    TextView tv = new TextView(MainActivity.this);
                    tv.setPadding(10, 10, 10, 10);
                    tv.setText(text);
                    tv.setTextSize(25);
                    tv.setTextColor(Color.GREEN);
                    tv.setGravity(Gravity.CENTER_HORIZONTAL);
                    rl.addView(tv);
                }
            }
        });

        btnBold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.removeAllViews();
                String text = input.getText().toString();
                TextView tv = new TextView(MainActivity.this);
                tv.setPadding(10, 10, 10, 10);
                tv.setText(text);
                tv.setTextSize(25);
                tv.setTextColor(Color.BLACK);
                tv.setGravity(Gravity.CENTER);
                tv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                rl.addView(tv);
                TextView item = new TextView(MainActivity.this);
                item.setPadding(10, 10, 10, 10);
                item.setTextSize(25);
                item.setTextColor(Color.BLACK);
                item.setGravity(Gravity.CENTER);
                rl.addView(item);
            }
        });

        btnItalic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl.removeAllViews();
                String text = input.getText().toString();
                TextView tv = new TextView(MainActivity.this);
                tv.setPadding(10, 10, 10, 10);
                tv.setText(text);
                tv.setTextSize(25);
                tv.setTextColor(Color.RED);
                tv.setGravity(Gravity.CENTER);
                tv.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                rl.addView(tv);
                TextView item = new TextView(MainActivity.this);
                item.setPadding(10, 10, 10, 10);
                item.setTextSize(25);
                item.setTextColor(Color.RED);
                item.setGravity(Gravity.CENTER);
                rl.addView(item);
            }
        });
    }

}
