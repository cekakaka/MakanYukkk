package com.dwicandra.makanyukkk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dwicandra.makanyukkk.Adapter.CartListAdapter;
import com.dwicandra.makanyukkk.Helper.ManagementCart;
import com.dwicandra.makanyukkk.Interface.ChangeNumberItemsListener;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView subTotalTxt, deliveryTxt, taxTxt, totalTxt, emptyTxt, checkout;
    private Double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);
        managementCart = new ManagementCart(this);

        initView();
        initList();
        calculateCart();
        bottomNavigation();
    }
    private void bottomNavigation() {
        ImageView dashboardHome = findViewById(R.id.dashboard_home1);
        ImageView dashboardCart = findViewById(R.id.dashboard_cart2);

        dashboardHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
            }
        });

        dashboardCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,CartListActivity.class));
            }
        });
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            checkout.setVisibility(View.GONE);
            scrollView.setVisibility(View.GONE);
        }else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.checkout();
            }
        });
    }

    private void calculateCart(){
        double percentTax = 0.02;
        double delivery = 10;

        tax = Math.round((managementCart.getTotalFee()*percentTax)*100.0)/100.0;
        double total = Math.round((managementCart.getTotalFee()+tax+delivery)*100.0)/100.0;

        subTotalTxt.setText("$"+managementCart.getTotalFee());
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$"+ total);
    }


    private void initView() {
        recyclerViewList = findViewById(R.id.recycleView);
        subTotalTxt = findViewById(R.id.subTotalTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        taxTxt = findViewById(R.id.taxTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView3);
        checkout = findViewById(R.id.checkout);
    }
}