package com.example.android.moonetkom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel1> mainModels;
    MainAdapter1 mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recyclerView=findViewById(R.id.recycler_view);
        String[] button_t={"Bakery","Fruits","Vegetables","Dairy","Drinks","Snacks","Home Care","Self Care","Kids"};
        mainModels=new ArrayList<>();
        for (int i=0;i<button_t.length;i++)
        {
            MainModel1 model=new MainModel1(button_t[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager=new LinearLayoutManager(ProductActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mainAdapter =new MainAdapter1(ProductActivity.this,mainModels);
        recyclerView.setAdapter(mainAdapter);
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
        TextView signout=(TextView) findViewById(R.id.signout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProductActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ImageView olives=(ImageView) findViewById(R.id.t_bakeryimg);
        olives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProductActivity.this,PageviewActivity.class);
                startActivity(intent);
                finish();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch(id)
                {
                    case R.id.nav_home:
                        Intent intent1 =new Intent(ProductActivity.this,HomeActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.nav_categorie:
                        Intent intent2 =new Intent(ProductActivity.this,CategoriesActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent intent3 =new Intent(ProductActivity.this,ProfileActivity.class);
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
        Intent intent=new Intent(ProductActivity.this,HomeActivity.class);
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
