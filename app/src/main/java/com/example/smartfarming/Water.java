package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Water extends AppCompatActivity {

    String waterCost;
    DatabaseReference databaseReference;
    private static final String error = "jms";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        EditText waterAmount =(EditText)findViewById(R.id.spinner2);
        TextView totalCost = (TextView) findViewById(R.id.cost2);
        TextView monthlyCost = (TextView) findViewById(R.id.cost1);
        Button button = (Button) findViewById(R.id.submitWater);

        Log.i(error,"a");
        databaseReference = FirebaseDatabase.getInstance().getReference();


        databaseReference.child("water_cost").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                monthlyCost.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Log.i(error,"b");

        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if ( !waterAmount.getText().toString().equals("") && !monthlyCost.getText().toString().equals(""))
                {
                    int x =Integer.parseInt(waterAmount.getText().toString());
                    int y =Integer.parseInt(monthlyCost.getText().toString());
                    totalCost.setText(String.valueOf(x*y));

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        waterAmount.addTextChangedListener(textWatcher);
        monthlyCost.addTextChangedListener(textWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String waterCost = totalCost.getText().toString();
                String timePeriod = waterAmount.getText().toString();
                Shop.waterTotalCost= waterCost;
                Shop.waterTimePeriod= timePeriod;

                Intent intent = new Intent(Water.this, Shop.class);
                startActivity(intent);
            }
        });

    }

}

