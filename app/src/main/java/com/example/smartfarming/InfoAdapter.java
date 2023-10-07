package com.example.smartfarming;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder> {
    private static final String error = "jms";
    Context context;
    ArrayList<InfoDetails> list;

    public InfoAdapter(Context context, ArrayList<InfoDetails> list) {
        this.context = context;
        this.list = list;

//        for (int x = 0; x < list.size(); x++){
//            Log.i(error,list.get(x).toString());
//        }

    }

    @NonNull
    @Override
    public InfoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_info_item, parent, false);
        return new InfoAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.MyViewHolder holder, int position) {

        InfoDetails infoDetails = list.get(position);
        holder.landName.setText(infoDetails.getLandName());
        holder.seedType.setText(infoDetails.getSeedType());
        holder.fertilizer.setText(infoDetails.getFertilizerType());

        holder.waterTimePeriod.setText(infoDetails.getWaterTimePeriod());
        Log.i(error,"infoDetails.getWaterPeriod() "+infoDetails.getWaterTimePeriod());

        holder.cultivationTime.setText(infoDetails.getCultivationTimePeriod());//infoDetails.getCultivationTimePeriod()
        holder.income.setText(infoDetails.getYourIncome());//infoDetails.getYourIncome()

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView landName, seedType, fertilizer, waterTimePeriod, cultivationTime, income;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Info info = new Info();

            landName = itemView.findViewById(R.id.tvLand);
            seedType = itemView.findViewById(R.id.tvSeed);
            fertilizer = itemView.findViewById(R.id.tvFertilizer);
            waterTimePeriod = itemView.findViewById(R.id.tvWater);
            cultivationTime = itemView.findViewById(R.id.tvTimePeriod);
            income = itemView.findViewById(R.id.tvIncome);

            income.setText("Pending....");

            waterTimePeriod.setText((CharSequence) info.seed);
            Log.i(error,"String.valueOf((CharSequence) info.seed "+ String.valueOf((CharSequence) info.seed));

        }
    }
}
