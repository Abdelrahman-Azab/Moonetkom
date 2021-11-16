package com.example.android.moonetkom;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForgetActivity extends AppCompatActivity {
private Button confirm_email;
private TextView go_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        confirm_email=(Button) findViewById(R.id.confirm_btn);
        confirm_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgetActivity.this,ConfirmationActivity.class);
                startActivity(intent);
            }
        });
        go_back=(TextView) findViewById(R.id.back_text);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgetActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(ForgetActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
