package com.dwicandra.makanyukkk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.dwicandra.makanyukkk.Adapter.DiscoveryAdapter;
import com.dwicandra.makanyukkk.Adapter.PopularAdapter;
import com.dwicandra.makanyukkk.Domain.DiscoveryDomain;
import com.dwicandra.makanyukkk.Domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewDiscoveryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewDiscovery();
        recyclerViewPopularList();
        bottomNavigation();
    }

    private void bottomNavigation() {
        ImageView dashboardHome = findViewById(R.id.dashboard_home1);
        ImageView dashboardCart = findViewById(R.id.dashboard_cart2);

        dashboardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });

        dashboardCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
    }

    private void recyclerViewPopularList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.popularItem);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();

        foodList.add(new FoodDomain("Lasagna","lasagna","Lasagna is the name of one of the oldest and best-known pasta shapes. It is usually rectangular or ribbon shaped, thicker than tagliatelle, made from a dough based on flour and eggs, with numerous local variants.",3.0));
        foodList.add(new FoodDomain("Chicken Leg","chicken_leg","Chicken leg refers to the whole leg portion of a chicken which is both the thigh and drumstick connected as one piece. When the whole leg is divided into 2 parts, it creates the thigh and drumstick portions. ",7.0));
        foodList.add(new FoodDomain("Remix Sticks","ice_cream_4","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",3.0));
        foodList.add(new FoodDomain("Spaghetti","spaghetti","paghetti bolognese consists of spaghetti (long strings of pasta) with an Italian ragù (meat sauce) made with minced beef, bacon and tomatoes, served with Parmesan cheese. Spaghetti bolognese is one of the most popular pasta dishes eaten outside of Italy.",5.3));
        adapter2 = new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewDiscovery() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewDiscoveryList = findViewById(R.id.discoveryItem);
        recyclerViewDiscoveryList.setLayoutManager(linearLayoutManager);

        ArrayList<DiscoveryDomain> discoveryList = new ArrayList<>();
        discoveryList.add(new DiscoveryDomain("Vanilla Flaviour"));
        discoveryList.add(new DiscoveryDomain("Chocolate Flaviour"));
        discoveryList.add(new DiscoveryDomain("Raspberry Duet"));
        discoveryList.add(new DiscoveryDomain("Buttered Pecan"));
        discoveryList.add(new DiscoveryDomain("Cookie Dough"));
        discoveryList.add(new DiscoveryDomain("Moose Tracks"));
        discoveryList.add(new DiscoveryDomain("Neapolitan"));

        adapter = new DiscoveryAdapter(discoveryList);
        recyclerViewDiscoveryList.setAdapter(adapter);

    }


}