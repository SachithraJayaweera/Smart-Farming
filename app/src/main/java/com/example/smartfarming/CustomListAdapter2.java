package com.example.smartfarming;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter2 extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> itemname;
    private final ArrayList<Integer> imgid;
   // private final Integer[] imgid;

    public CustomListAdapter2(Activity context, ArrayList<String> itemname, ArrayList<Integer> imgid){

        super(context, R.layout.activity_custom_list_adapter2, itemname);
        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }

    public View getView(int positon, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.activity_custom_list_adapter2, null, true);
        TextView txtTile = (TextView) rowView.findViewById(R.id.itemname);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTile.setText(itemname.get(positon));
        imageView.setImageResource(imgid.get(positon));
        return rowView;
    };
}