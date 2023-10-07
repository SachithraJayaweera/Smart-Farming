package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.smartfarming.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.munu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
        }
        return super.onOptionsItemSelected(item);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    ListView list;
    String[] text_list ={
            "MY LAND",
            "SHOP",
            "MORE INFO",
            "YOUR ORDERS",
            "SEND MAILS"
    };


    String[] condition ={
            "Available",
            "Available",
            "Available",
            "Available",
            "Available"
    };

    Integer[] icon_list = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        CustomListAdapter adapter = new CustomListAdapter(this, text_list, condition, icon_list);
        list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String value = extras.getString("ID");
                    //The key argument here must match that used in the other activity
                }

                try{
                    if (position == 0) {
                        Intent intent = new Intent(MainActivity.this, Info.class);
                        startActivity(intent);
                    }

                    if (position == 1) {
                        Intent intent = new Intent(MainActivity.this, Shop.class);
                        startActivity(intent);
                    }

                    if (position == 2) {
                        Intent intent = new Intent(MainActivity.this, VisitCultivation.class);
                        startActivity(intent);
                    }

                    if (position == 3) {
                        Intent intent = new Intent(MainActivity.this, YourOders.class);
                        startActivity(intent);
                    }

                    if (position == 4) {
                        Intent intent = new Intent(MainActivity.this, SendMails.class);
                        startActivity(intent);
                    }


                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        });
    }


    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit");
         builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit from the app?")
                .setCancelable(false)
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

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