package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.smartfarming.databinding.ActivityInfoBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

public class Info extends AppCompatActivity{

    RecyclerView recyclerView;
    DatabaseReference database;
    InfoAdapter infoAdapter;
    ArrayList<InfoDetails> list;
    public List<String> seed;

    private static final String error = "jms";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        recyclerView = findViewById(R.id.infoList);
        database = FirebaseDatabase.getInstance().getReference("orders").child(Login.NIC);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
  //
        infoAdapter = new InfoAdapter(this,list);


        seed = new ArrayList<>();
        recyclerView.setAdapter(infoAdapter);

        database.child("seeds").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot childSnapshot1: snapshot.getChildren()) {
                    String growTime = childSnapshot1.child("grow_time").getValue(String.class);
                    seed.add(growTime);

                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    InfoDetails infoDetails = dataSnapshot.getValue(InfoDetails.class);
                    list.add(infoDetails);

                       // Log.i(error,"list1.get(x).toString() "+list.getClass().toString());

                }
                infoAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}

