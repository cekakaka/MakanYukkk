package com.dwicandra.makanyukkk.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dwicandra.makanyukkk.Domain.FoodDomain;
import com.dwicandra.makanyukkk.FoodDetailsActivity;
import com.dwicandra.makanyukkk.Helper.ManagementCart;
import com.dwicandra.makanyukkk.Interface.ChangeNumberItemsListener;
import com.dwicandra.makanyukkk.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    private ArrayList<FoodDomain> foodDomain;
    private ManagementCart managementCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<FoodDomain> FoodDomain, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.foodDomain = FoodDomain;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(foodDomain.get(position).getTitle());
        holder.totalEachItem.setText(String.valueOf(Math.round((foodDomain.get(position).getNumberCardId()*foodDomain.get(position).getprice())*100.0)/100.0));
        holder.num.setText(String.valueOf(foodDomain.get(position).getNumberCardId()));

        // use Glide to load Images
        int drawableResource = holder.itemView.getContext().getResources().getIdentifier(foodDomain.get(position).getPict(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResource)
                .into(holder.pict);

        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.plusNumberFood(foodDomain, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });

        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.minusNumberFood(foodDomain, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {

        return foodDomain.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, priceEachItem, totalEachItem, num;
        ImageView pict, plusItem, minusItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title2Txt);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            pict = itemView.findViewById(R.id.pictCart);
            num = itemView.findViewById(R.id.numberItemTxt);
            plusItem = itemView.findViewById(R.id.plus2Btn);
            minusItem = itemView.findViewById(R.id.min2Btn);
        }
    }
}
