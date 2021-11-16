package com.example.android.moonetkom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(ConfirmationActivity.this,ForgetActivity.class);
        startActivity(intent);
        finish();
    }
}
