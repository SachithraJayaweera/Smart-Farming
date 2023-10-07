package com.example.smartfarming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>{
    Context context;
    ArrayList<OrderDetails> list;


    public OrderAdapter(Context context, ArrayList<OrderDetails> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_your_order_item, parent, false);
        return new OrderAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        OrderDetails orderDetails = list.get(position);
        //if(orderDetails.getStatus().toString()=="Pending") {
            holder.seedCost.setText(orderDetails.getTotalSeedCost());
            holder.landCost.setText(orderDetails.getLandCost());
            holder.waterCost.setText(orderDetails.getWaterTotalCost());
            holder.fertilizerCost.setText(orderDetails.getTotalFertilizerCost());
            holder.totalCost.setText(orderDetails.getOverallCost());
            holder.status.setText(orderDetails.getStatus());
       // }
    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView seedCost, landCost, waterCost, fertilizerCost, totalCost, status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            seedCost = itemView.findViewById(R.id.tvId);
            landCost = itemView.findViewById(R.id.tvName);
            waterCost = itemView.findViewById(R.id.tvSize);
            fertilizerCost = itemView.findViewById(R.id.tvPrice);
            totalCost = itemView.findViewById(R.id.tvTotal);
            status = itemView.findViewById(R.id.tvStatus);

        }
    }
}
