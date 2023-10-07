package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    private static final String error = "jms";
    EditText txtName, txtEmail, txtPwd, txtAddress, txtTel, txtNic;
    Button btnLogin;
    ProgressBar progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView login = (TextView)findViewById(R.id.lnkLogin);
        login.setMovementMethod(LinkMovementMethod.getInstance());

        txtName = findViewById(R.id.firstName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPwd = findViewById(R.id.txtPwd);
        txtAddress = findViewById(R.id.address);
        txtTel = findViewById(R.id.telNo);
        txtNic = findViewById(R.id.nic);
        btnLogin = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
                Log.i(error,"Login button");
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nic = txtNic.getText().toString();
                String name = txtName.getText().toString();
                String email = txtEmail.getText().toString();
               // String exemail = email.replace(".","_");
                String password = txtPwd.getText().toString();
                String address = txtAddress.getText().toString();
                String tel = txtTel.getText().toString();

                DatabaseReference db_rfe = FirebaseDatabase.getInstance().getReference().child("customer").child(nic);
                if (TextUtils.isEmpty(nic)) {
                    txtNic.setError("NIC is Required.");
                    return;
                }else if (TextUtils.isEmpty(name)){
                    txtName.setError("First name is Required.");
                    return;
                }else if (TextUtils.isEmpty(email)){
                    txtEmail.setError("Email is Required");
                    return;
               }else if (TextUtils.isEmpty(password)){
                    txtPwd.setError("Password is Required");
                    return;
                }else if (TextUtils.isEmpty(address)){
                    txtAddress.setError("address is Required");
                    return;
                }else if (TextUtils.isEmpty(tel)){
                    txtTel.setError("tel is Required");
                    return;
                }else if (password.length()<6){
                    txtPwd.setError("Password must be >= 6 characters");
               }else{
                    Log.i(error,"2");
                    db_rfe.child("customer").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(nic)){
                                Log.i(error,"3");
                             Toast.makeText(Register.this,"this nic already used", Toast.LENGTH_LONG).show();
                                Log.i(error,"4");
                            }else{
                                Customer customer = new Customer(nic,name,email,password,address,tel);
                                db_rfe.setValue(customer);

                                Log.i(error,"5");
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
        });
     }
  }