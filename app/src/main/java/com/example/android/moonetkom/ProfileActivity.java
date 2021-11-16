package com.example.android.moonetkom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar) findViewById(R.id.title_bar);
        setSupportActionBar(toolbar);
        LinearLayout editprofile= (LinearLayout) findViewById(R.id.edit_profile);
        LinearLayout changelanguage=(LinearLayout) findViewById(R.id.change_language);
        LinearLayout contacthus=(LinearLayout) findViewById(R.id.contact_us);

        contacthus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this,ContactusActivity.class);
                startActivity(intent);
                finish();
            }
        });
        changelanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this,LangaugeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        final DrawerLayout drawerLayout =findViewById(R.id.drawer);
        NavigationView navigationView=findViewById(R.id.navigation_view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch(id)
                {
                    case R.id.nav_home:
                        Intent intent1 =new Intent(ProfileActivity.this,HomeActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.nav_categorie:
                        Intent intent2 =new Intent(ProfileActivity.this,CategoriesActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent intent3 =new Intent(ProfileActivity.this,ProfileActivity.class);
                        startActivity(intent3);
                        finish();
                        break;


                    default:
                        return true;
                }
                return true;
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(ProfileActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    }

