package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NewsFragmentFirst fo;
    NewsFragmentSecond fs;

    private ProgressDialog dialog;
    int show = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fo = new NewsFragmentFirst();
        fs = new NewsFragmentSecond();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.cLayout,fo);
        fragmentTransaction.commit();
        show = 1;

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_WIFI_STATE}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, PackageManager.PERMISSION_GRANTED);

    }

    public void switchFragment(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if( show == 1){
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Changing Language");
            dialog.setCancelable(false);
            dialog.show();

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    dialog.dismiss();
                }
            }, 3000);
            fragmentTransaction.replace(R.id.cLayout,fs);
            show = 2;

        }
        else{
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Changing Language");
            dialog.setCancelable(false);
            dialog.show();

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    dialog.dismiss();
                }
            }, 3000);
            fragmentTransaction.replace(R.id.cLayout,fo);
            show = 1;
        }
        fragmentTransaction.commit();
    }
}
