package com.dwicandra.makanyukkk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

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
    }

    private void recyclerViewPopularList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList = findViewById(R.id.popularItem);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Potato Chips","food1","",5.0));
        foodList.add(new FoodDomain("Omlette","food2","",5.0));

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
        discoveryList.add(new DiscoveryDomain("Sayur Asam"));
        discoveryList.add(new DiscoveryDomain("Tempe Penyet"));
        discoveryList.add(new DiscoveryDomain("Tempe Goreng"));
        discoveryList.add(new DiscoveryDomain("Ayam Goyeng"));
        discoveryList.add(new DiscoveryDomain("Tempe Penyet"));

        adapter = new DiscoveryAdapter(discoveryList);
        recyclerViewDiscoveryList.setAdapter(adapter);

    }


}