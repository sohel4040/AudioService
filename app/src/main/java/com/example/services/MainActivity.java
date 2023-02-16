package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b= findViewById(R.id.stop);







        //Background Service
//        Intent i = new Intent(this,MyService.class);
//        startService(i);



        //Foreground Service
        Intent i = new Intent(this,FService.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Toast.makeText(this, ""+Build.VERSION.SDK_INT+" : "+Build.VERSION_CODES.O, Toast.LENGTH_SHORT).show();
            startForegroundService(i);
        }
        else
        {
            Toast.makeText(this, "Foreground Service not Supported", Toast.LENGTH_SHORT).show();
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(MainActivity.this,FService.class);
                stopService(i1);
            }
        });


    }
}