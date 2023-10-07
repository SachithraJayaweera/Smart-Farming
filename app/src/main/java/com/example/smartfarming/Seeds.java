package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import java.util.ArrayList;
import java.util.List;


public class Seeds extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

  //private static final String error = "jms";

   DatabaseReference databaseReference;
   List<String> seed;
   List<String> price;
   List<String> reqAmount;

   //ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeds);

        Spinner spiner = (Spinner) findViewById(R.id.spinner1);
        TextView value = (TextView) findViewById(R.id.value);
        EditText area = (EditText) findViewById(R.id.area);
        TextView amount = (TextView) findViewById(R.id.amount);
        TextView total = (TextView) findViewById(R.id.total);
        TextView cost = (TextView) findViewById(R.id.cost);
        Button button = (Button) findViewById(R.id.add);

        seed = new ArrayList<>();
        price = new ArrayList<String>();
        reqAmount = new ArrayList<String>();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("seeds").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot childSnapshot1: snapshot.getChildren()) {
                    String spinnerName1 = childSnapshot1.child("name").getValue(String.class);
                    String spinnerName2 = childSnapshot1.child("price").getValue(String.class);
                    String spinnerName3 = childSnapshot1.child("amount").getValue(String.class);

                    seed.add(spinnerName1);
                    price.add(spinnerName2);
                    reqAmount.add(spinnerName3);
                }
                ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(Seeds.this, android.R.layout.simple_spinner_item, seed);
                arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spiner.setAdapter(arrayAdapter1);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String totalCost = cost.getText().toString();
               String totalAmount = amount.getText().toString();
               String SeedType = spiner.getSelectedItem().toString();

               Shop.totalSeedCost = totalCost;
               Shop.totalSeedAmount = totalAmount;

               Shop.seedType = SeedType;

               Intent intent = new Intent(Seeds.this, Shop.class);
               startActivity(intent);
              }
        });

        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                try {
                    value.setText(String.valueOf(price.get(i)));
                    amount.setText(String.valueOf(reqAmount.get(i)));

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //int x = spiner.getSelectedItemPosition();
//        value.setText(this.value[x]);
//        amount.setText(this.amount[x]);

        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!area.getText().toString().equals(""))
                {
                    int x =Integer.parseInt(area.getText().toString());
                    int y =Integer.parseInt(amount.getText().toString());
                    int z =Integer.parseInt(value.getText().toString());
                    total.setText(String.valueOf(x*y));
                    cost.setText(String.valueOf(x*y*z));

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        area.addTextChangedListener(textWatcher);
        //amount.addTextChangedListener(textWatcher);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


