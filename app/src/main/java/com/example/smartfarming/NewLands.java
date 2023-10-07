package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewLands extends AppCompatActivity {

    private static final String error = "jms";

    ListView list;
    Button btn;
    ArrayList<String> text_list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    DatabaseReference getRef;
    LandData land;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_lands);

        land = new LandData();
        list = (ListView) findViewById(R.id.list_view);
        getRef = FirebaseDatabase.getInstance().getReference( "lands");

        text_list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.land_info,R.id.landInfo, text_list);

        getRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i(error,"a");
                for (DataSnapshot ds: snapshot.getChildren()){
                    Log.i(error,"b");

                    land = ds.getValue(LandData.class);
                    text_list.add(land.getName().toString()+" "+land.getPrice().toString());
                    Log.i(error,"c");
                }
                list.setAdapter(adapter);
                Log.i(error,"d");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
/*
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String landData = text_list.get(+position);
                Toast.makeText(getApplicationContext(),landData,Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}