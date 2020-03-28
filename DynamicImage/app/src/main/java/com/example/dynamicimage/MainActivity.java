package com.example.dynamicimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {

    Button draw, online;
    CircleImageView imageView;
    ConstraintLayout cl;
    String url = "https://pixabay.com/illustrations/spacex-spaceship-satellite-orbit-693229/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw = findViewById(R.id.btnImg1);
        online = findViewById(R.id.btnImg2);
        imageView = findViewById(R.id.imageView);
        cl = findViewById(R.id.cLayout);

        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl.setVisibility(View.VISIBLE);
                Picasso.get().load(R.mipmap.ic_launcher).into(imageView);
            }
        });

        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl.setVisibility(View.VISIBLE);
                Picasso.get().load(url).into(imageView);
            }
        });
    }
}
