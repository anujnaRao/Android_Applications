package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText num,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.btn);
        num= findViewById(R.id.number);
        msg= findViewById(R.id.body);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSmsByIntent();
            }
        });

    }

    public void sendSmsByIntent(){
        Uri uri=Uri.parse("SMSto:" +num.getText().toString());

        Intent smsIntent=new Intent(Intent.ACTION_SENDTO,uri);
        smsIntent.putExtra("SMS body", msg.getText().toString());
        try{
            startActivity(smsIntent);
        }
        catch (Exception ex)
        {
            Toast.makeText(MainActivity.this,"Message has failed..",Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }
}
