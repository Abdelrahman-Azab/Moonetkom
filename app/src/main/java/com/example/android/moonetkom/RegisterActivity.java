package com.example.android.moonetkom;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
private TextView go_back;
private Button Register_button;
    private EditText email;
    private EditText password;
    private EditText re_password;
    private EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        go_back=(TextView) findViewById(R.id.back_text);
        Register_button=(Button) findViewById(R.id.reg_btn);
        email = (EditText) findViewById(R.id.email_edittext);
        password = (EditText) findViewById(R.id.password_edittext);
        re_password = (EditText) findViewById(R.id.re_password_edittext);
        phone = (EditText) findViewById(R.id.phone_edittext);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill = email.getText().toString();
                String passwordd = password.getText().toString();
                String re_passwordd = re_password.getText().toString();
                String phonee = phone.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if ( emaill.equals("") || passwordd.equals("") || re_passwordd.equals("") || phonee.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Empty Creditianls", Toast.LENGTH_SHORT).show();
                } else if (!passwordd.equals(re_passwordd)) {
                    Toast.makeText(RegisterActivity.this, "Password Doesn't match", Toast.LENGTH_SHORT).show();
                } else if (passwordd.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                } else if (phonee.length() != 8) {
                    Toast.makeText(RegisterActivity.this, "Phone length is wrong", Toast.LENGTH_SHORT).show();
                }
                else if(!emaill.matches(emailPattern)) {
                    Toast.makeText(RegisterActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                }
                    else
                 {
                    Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegisterActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
