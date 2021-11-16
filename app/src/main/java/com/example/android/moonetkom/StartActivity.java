package com.example.android.moonetkom;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             Intent intent= new Intent(StartActivity.this,LoginActivity.class);
             startActivity(intent);
             finish();
            }
        },SPLASH_TIME_OUT);

    }
}
