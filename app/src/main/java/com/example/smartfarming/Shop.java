package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Shop extends AppCompatActivity {

    int count=0;
    private static final String error = "jms";

    String newStatus = "Pending";
    String cultivationTimePeriod = "";
    String yourIncome = "wait till the time period";

    public static String nic, landName, seedType, totalSeedAmount, totalSeedCost, fertilizerType, totalFertilizerAmount, totalFertilizerCost, waterTimePeriod, waterTotalCost, landID, landCost, overallCost ;

    Button btn1, btn2, btn3, btn4, confirm;
    TextView cost1, cost2, cost3, cost4, total, status, payText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        cost1 = findViewById(R.id.seedCost);
        cost2 = findViewById(R.id.ferCost);
        cost3 = findViewById(R.id.waterCost);
        cost4 = findViewById(R.id.landCost);
        total = findViewById(R.id.allTotal);
        confirm = findViewById(R.id.confirm);
        status = findViewById(R.id.status);
        payText = findViewById(R.id.payText);

        cost1.setText(totalSeedCost);
        cost2.setText(totalFertilizerCost);
        cost3.setText(waterTotalCost);
        cost4.setText(landCost);



        if (!cost1.getText().toString().equals("") && !cost2.getText().toString().equals("")
              && !cost3.getText().toString().equals("")&& !cost4.getText().toString().equals("")) {
            int p = Integer.parseInt(cost1.getText().toString());
            int q = Integer.parseInt(cost2.getText().toString());
            int r = Integer.parseInt(cost3.getText().toString());
            int s = Integer.parseInt(cost4.getText().toString());
            total.setText(String.valueOf(p + q + r + s));
        }

        overallCost = total.getText().toString();


        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                
                AlertDialog.Builder builder = new AlertDialog.Builder(Shop.this);
                builder.setTitle("Alert");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Are you sure want to confirm?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                count = count + 1;
                                String NIC = Login.NIC;
                                Log.i(error, "NIC " +NIC);


                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("orders").child(Login.NIC);
                                databaseReference.child("orders").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                                        Oder oder = new Oder(Login.NIC, landName,seedType, totalSeedAmount, totalSeedCost, fertilizerType, totalFertilizerAmount, totalFertilizerCost, waterTimePeriod, waterTotalCost, landID, landCost, overallCost, newStatus, cultivationTimePeriod, yourIncome);
                                        databaseReference.push().setValue(oder);

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }

                                });
                                Intent intent = new Intent(Shop.this, Shop.class);
                                startActivity(intent);
                                finish();
                                status.setText(newStatus);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shop.this, Seeds.class);
                startActivity(intent);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shop.this, Fertilizer.class);
                startActivity(intent);
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shop.this, Water.class);
                startActivity(intent);
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shop.this, RecycleLand.class);
                startActivity(intent);

            }
        });
    }

    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Shop.this);
        builder.setTitle("Alert");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("If you want to change anything, change them before going to the main menu")
                .setCancelable(false)
                .setPositiveButton("Go", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Shop.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}