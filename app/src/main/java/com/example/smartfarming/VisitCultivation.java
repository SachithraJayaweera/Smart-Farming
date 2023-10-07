package com.example.smartfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VisitCultivation extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_cultivation);

        btn = findViewById(R.id.button);
        Intent i = new Intent(Intent.ACTION_SEND);
        final Intent chooser;
        i.setData(Uri.parse("mailto:"));
        //        i.putExtra(Intent.EXTRA_EMAIL,new String[]{"sanjeewasampath4u@gmail.com"});
//        i.putExtra(Intent.EXTRA_SUBJECT, "This is my test subject");
//        i.putExtra(Intent.EXTRA_TEXT,"This is our email body");

        i.setType("message/rfc822");
        //        Intent sky = new Intent("Intent.ACTION_SEND");
        chooser = Intent.createChooser(i,"Send email test app");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(chooser);
            }
        });

    }
}