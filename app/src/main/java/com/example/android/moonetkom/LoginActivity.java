package com.example.android.moonetkom;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
private TextView Forget_password;
private Button Register_btn;
    private EditText email;
    private EditText password;
    private Button login;
    private Button login_as_guest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Forget_password=(TextView) findViewById(R.id.forget_text);
        Register_btn=(Button) findViewById(R.id.reg_btn);
        email=(EditText) findViewById(R.id.email_edittext);
        password=(EditText) findViewById(R.id.password_edittext);
        login=(Button) findViewById(R.id.log_btn);
        login_as_guest=(Button) findViewById(R.id.login_as_guest_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaill=email.getText().toString();
                String passwordd=password.getText().toString();
                if(emaill.equals("") || passwordd.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Empty Creditianls", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                    intent.putExtra("Email",emaill);
                    startActivity(intent);
                    finish();
                }

            }
        });
        Forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,ForgetActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        login_as_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
