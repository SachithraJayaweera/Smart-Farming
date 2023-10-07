package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
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

public class Login extends AppCompatActivity {

    EditText nic,Password;
    Button Login;
    ProgressBar progress2;
    public static String NIC = "00000";

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://smart-farming-6a1b6-default-rtdb.firebaseio.com/");
    private static final String error = "jms";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nic = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        progress2 = findViewById(R.id.progress2);
        //Auth2 = FirebaseAuth.getInstance();
        Login = findViewById(R.id.Login);

        TextView register = findViewById(R.id.lnkRegister);
        register.setMovementMethod(LinkMovementMethod.getInstance());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nicx = nic.getText().toString().trim();
                String password = Password.getText().toString().trim();
                NIC = nic.getText().toString().trim();
                databaseReference.child("customer").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.hasChild(nicx)){

                            final String get_nic = snapshot.child(nicx).child("password").getValue(String.class);

                            if (get_nic.equals(password)){
                                Toast.makeText(Login.this,"Successfully logged in",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this,MainActivity .class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Login.this,"Wrong password",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                if (TextUtils.isEmpty(nicx)){
                    nic.setError("nic is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Password.setError("Password is Required");
                    return;
                }

                if (password.length()<6){
                    Password.setError("Password must be >= 6 characters");
                }
/*
                progress2.setVisibility(View.VISIBLE);

                Auth2.signInWithEmailAndPassword(nic,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Login.this, "Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progress2.setVisibility(View.GONE);
                        }
                    }
                });
*/
            }
        });

    }
}