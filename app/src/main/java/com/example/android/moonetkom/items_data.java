package com.example.android.moonetkom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class items_data extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Modelitems> mainmodels;
MainAdapteritems mainAdapteritems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_data);
        String schoice=getIntent().getStringExtra("Choice");
        int choice=Integer.parseInt(schoice);
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
                        Intent intent1 =new Intent(items_data.this,HomeActivity.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.nav_categorie:
                        Intent intent2 =new Intent(items_data.this,CategoriesActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                    case R.id.nav_profile:
                        Intent intent3 =new Intent(items_data.this,ProfileActivity.class);
                        startActivity(intent3);
                        finish();
                        break;


                    default:
                        return true;
                }
                return true;
            }
        });
        if(choice==1) {

            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            Integer[] items_pic = {R.drawable.canary, R.drawable.gofresh, R.drawable.coco, R.drawable.nouba, R.drawable.crepe, R.drawable.hawaii, R.drawable.puff, R.drawable.dimez, R.drawable.candybar};
            String[] description = {"Canary Coco Cream Filled Wafers 65g", "go fresh Cocoa Coated Wafer with Milk cream 20g", "cece bon suger coated Compound Chocolate Dragee 22g"
                    , "Nouba Wafer stuffed and covered with cocoa 100g", "Crepe Kakaolu findik Kremali Gofret 16g", "HAWAII Real Coconut Enrobed in a milk Chocolate Sensation 25g"
                    , "jordina puff pastries filled with cocoa cream ingredients", "Swich Dimez chocolate coated choc chip cookies ×4 Biscuits 24g", "kemeh candy bar Biscuit & cream and peants with covared chocolate 24g"};
            String[] price = {"0.3", "0.1", "0.1", "0.1", "0.1", "1", "0.1", "0.1", "0.1", "0.1"};
            mainmodels = new ArrayList<>();
            for (int i = 0; i < items_pic.length; i++) {
                Modelitems model = new Modelitems(items_pic[i], description[i], price[i]);
                mainmodels.add(model);
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            mainAdapteritems = new MainAdapteritems(items_data.this, mainmodels);
            recyclerView.setAdapter(mainAdapteritems);

        }
        else if(choice==2)
        {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        Integer[] items_pic = {R.drawable.pik_one, R.drawable.jacky, R.drawable.ohboy, R.drawable.humhum, R.drawable.kunuz, R.drawable.stars, R.drawable.gearup, R.drawable.majesto, R.drawable.skittles};
        String[] description = {"gandour pik-one 2 wafer fingers Enrobedin milk Chocolate 15.5g", "jacky cocoa coated wafer with cocoa cream 20g", "swich OH Boy ORIGINAL cream Biscuit 38g"
                , "HUM HUM Coconut & Chocolate 25g", "Gandour kunuz soft candy tropical fruit flavor 16g", "Elegance stars standard biscuits with chocolate and milk cream 6 pieces 34g"
                , "piccadeli gear up crunchy wafer coated with milk chocolate 18g", "Tiffany majesto Hazelnut cream wafers 25g", "skittles fruits flavored 38g"};
        String[] price = {"0.3", "0.1", "0.1", "0.1", "0.1", "1", "0.1", "0.1", "0.1", "0.1"};
        mainmodels = new ArrayList<>();
        for (int i = 0; i < items_pic.length; i++) {
            Modelitems model = new Modelitems(items_pic[i], description[i], price[i]);
            mainmodels.add(model);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mainAdapteritems = new MainAdapteritems(items_data.this, mainmodels);
        recyclerView.setAdapter(mainAdapteritems);

    }
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(items_data.this,CategoriesActivity.class);
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
