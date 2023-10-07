package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class YourOders extends AppCompatActivity {

    RecyclerView recyclerView;
    OrderAdapter orderAdapter;
    DatabaseReference databaseReference1;
    ArrayList<OrderDetails> list;
    private static final String error = "jms";

   // DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://smart-farming-6a1b6-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_oders);
        Log.i(error, "1");

        recyclerView = findViewById(R.id.orderList);
       // database1 = FirebaseDatabase.getInstance().getReference("orders").child(Login.NIC).child("status");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("orders").child(Login.NIC);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        orderAdapter = new OrderAdapter(this,list);

        recyclerView.setAdapter(orderAdapter);

        try {
            databaseReference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        OrderDetails orderDetails = dataSnapshot.getValue(OrderDetails.class);
                        list.add(orderDetails);
                    }
                    orderAdapter.notifyDataSetChanged();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }

/*
        try {
            databaseReference.child("orders").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.hasChild(Login.NIC)){

                        final String get_status = snapshot.child(Login.NIC).child("status").getValue(String.class);

                        if (get_status.equals("Pending")){

                            Toast.makeText(YourOders.this,"Pending",Toast.LENGTH_LONG).show();


                            try {
                                databaseReference1.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                                            OrderDetails orderDetails = dataSnapshot.getValue(OrderDetails.class);
                                            list.add(orderDetails);

                                        }
                                        orderAdapter.notifyDataSetChanged();

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                            }catch (Exception e){
                                e.printStackTrace();
                            }

                        }else {
                            Toast.makeText(YourOders.this,"accepted",Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
*/

    }
}