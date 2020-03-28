package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button ok,cancel;
    EditText username,password;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok= findViewById(R.id.signin);
        cancel=findViewById(R.id.cancel);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("Astrid") && password.getText().toString().equals("hiccup"))
                {
                    Toast.makeText(getApplicationContext(),"Login Validated",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }
                else {
                    count++;
                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                    if (count == 3)
                    {
                        ok.setEnabled(false);
                        Toast.makeText(getApplicationContext(), "Wait for 5 seconds", '1').show();
                        new CountDownTimer(10000, 100) {

                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                ok.setEnabled(true);
                                count = 0;
                            }
                        }.start();
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
