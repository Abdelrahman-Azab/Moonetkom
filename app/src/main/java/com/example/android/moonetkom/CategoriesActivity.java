package com.example.android.moonetkom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ImageView bakery=(ImageView) findViewById(R.id.t_bakeryimg);
        ImageView fruits=(ImageView) findViewById(R.id.t_fruitsimg);
        bakery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(CategoriesActivity.this,items_data.class);
                intent1.putExtra("Choice","1");
                startActivity(intent1);
                finish();
            }
        });
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(CategoriesActivity.this,items_data.class);
                intent1.putExtra("Choice","2");
                startActivity(intent1);
                finish();
            }
        });
        androidx.appcompat.widget.Toolbar toolbar=(androidx.appcompat.widget.Toolbar) findViewById(R.id.title_bar);
        setSupportActionBar(toolbar);
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
                        Intent intent1 =new Intent(CategoriesActivity.this,HomeActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.nav_categorie:
                        Intent intent2 =new Intent(CategoriesActivity.this,CategoriesActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent intent3 =new Intent(CategoriesActivity.this,ProfileActivity.class);
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
        Intent intent=new Intent(CategoriesActivity.this,HomeActivity.class);
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

