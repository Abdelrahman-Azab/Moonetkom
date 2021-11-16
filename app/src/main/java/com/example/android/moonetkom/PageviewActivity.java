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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class PageviewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter2 mainAdapter;
    Integer cnt=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageview);
        Button plus=(Button) findViewById(R.id.plus_button);
        Button minus=(Button) findViewById(R.id.minus_button);
        final TextView quantity=(TextView) findViewById(R.id.text_quantity);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;
                quantity.setText(cnt.toString());
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt==1)
                {
                    Toast.makeText(PageviewActivity.this,"Sorry, atleast 1 product",Toast.LENGTH_SHORT).show();
                    quantity.setText(cnt.toString());
                }
                else {
                    cnt--;
                    quantity.setText(cnt.toString());
                }
            }
        });
        recyclerView=findViewById(R.id.recycler_view);
        Integer [] cardslogo={R.drawable.apple_p,R.drawable.orange_p,R.drawable.strawberry_p,R.drawable.avocado_p,R.drawable.watermelon_p};
        mainModels=new ArrayList<>();
        for (int i=0;i<cardslogo.length;i++)
        {
            MainModel model=new MainModel(cardslogo[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager=new LinearLayoutManager(PageviewActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mainAdapter =new MainAdapter2(PageviewActivity.this,mainModels);
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
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch(id)
                {
                    case R.id.nav_home:
                        Intent intent1 =new Intent(PageviewActivity.this,HomeActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.nav_categorie:
                        Intent intent2 =new Intent(PageviewActivity.this,CategoriesActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent intent3 =new Intent(PageviewActivity.this,ProfileActivity.class);
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
        Intent intent=new Intent(PageviewActivity.this,ProductActivity.class);
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

