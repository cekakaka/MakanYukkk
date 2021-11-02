package com.dwicandra.makanyukkk.Adapter;

import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ContentInfoCompat;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;

import com.dwicandra.makanyukkk.Domain.DiscoveryDomain;
import com.dwicandra.makanyukkk.R;

import java.util.ArrayList;

public class DiscoveryAdapter extends RecyclerView.Adapter<DiscoveryAdapter.ViewHolder> {

    ArrayList<DiscoveryDomain> discoveryDomain;

    public DiscoveryAdapter(ArrayList<DiscoveryDomain> discoveryDomain) {
        this.discoveryDomain = discoveryDomain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_discovery,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.discoveryName.setText(discoveryDomain.get(position).getTitle());
        //String pictUrl ="";
        switch (position){
            case 0:{
                //pictUrl=(ambil dari drawable);
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.discovery_background1));
                break;
            }
            case 1:{
                //pictUrl=(ambil dari drawable);
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.discovery_background2));
                break;
            }
            case 2:{
                //pictUrl = (ambil dari drawable);
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.discovery_background3));
                break;
            }
            case 3:{
                //pictUrl = (ambil dari drawable);
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.discovery_background4));
                break;
            }
            case 4:{
                //pictUrl = (ambil dari drawable);
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.discovery_background5));
                break;
            }
        }
        // use Glide to load Images
        /*int drawableResource = holder.itemView.getContext().getResources().getIdentifier(pictUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResource)
                .into(holder.//categoryPict)*/
    }


    @Override
    public int getItemCount() {

        return discoveryDomain.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView discoveryName;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            discoveryName = itemView.findViewById(R.id.discoveryName);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
