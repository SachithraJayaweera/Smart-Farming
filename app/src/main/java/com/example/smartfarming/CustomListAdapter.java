package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] day;
    private final String[] description;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] day, String[] description, Integer[] imgid ) {
        super(context, R.layout.activity_custom_list_adapter, day);
        this.context = context;
        this.day = day;
        this.imgid = imgid;
        this.description = description;
    }

    public View getView(int positon, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_custom_list_adapter, null, true);
        TextView txtTile = (TextView) rowView.findViewById(R.id.topic);
        TextView txtDes = (TextView) rowView.findViewById(R.id.description);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTile.setText(day[positon]);
        txtDes.setText(description[positon]);
        imageView.setImageResource(imgid[positon]);
        return rowView;
    };

}