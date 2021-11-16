package com.example.android.moonetkom;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String email=getIntent().getStringExtra("Email");
        recyclerView=findViewById(R.id.recycler_view);
        Integer [] cardslogo={R.drawable.olivescard,R.drawable.strawberrycard,R.drawable.avocadocard,R.drawable.watermeloncard,R.drawable.coconutcard,R.drawable.cheesecard};
        mainModels=new ArrayList<>();
        for (int i=0;i<cardslogo.length;i++)
        {
            MainModel model=new MainModel(cardslogo[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager=new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mainAdapter =new MainAdapter(HomeActivity.this,mainModels);
        recyclerView.setAdapter(mainAdapter);
        Button category=(Button) findViewById(R.id.view_all_category);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,CategoriesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        TextView signout=(TextView) findViewById(R.id.signout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button product=(Button)  findViewById(R.id.view_all_product);
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HomeActivity.this,ProductActivity.class);
                startActivity(intent);
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
                Intent intent1 =new Intent(HomeActivity.this,HomeActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.nav_categorie:
                Intent intent2 =new Intent(HomeActivity.this,CategoriesActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.nav_profile:
                Intent intent3 =new Intent(HomeActivity.this,ProfileActivity.class);
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
        Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
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
