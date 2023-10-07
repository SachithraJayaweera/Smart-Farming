package com.example.smartfarming;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;
    private ItemClickListener mItemListener;

    public MyAdapter(Context context, ArrayList<User> list, ItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.mItemListener = itemClickListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_land_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.landID.setText(user.getLandID());
        holder.landName.setText(user.getLandName());
        holder.landSize.setText(user.getLandSize());
        holder.landPrice.setText(user.getLandPrice());

        holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(list.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface ItemClickListener{
        void onItemClick(User details);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView landID, landName, landSize, landPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            landID = itemView.findViewById(R.id.tvId);
            landName = itemView.findViewById(R.id.tvName);
            landSize = itemView.findViewById(R.id.tvSize);
            landPrice = itemView.findViewById(R.id.tvPrice);

        }
    }
}
