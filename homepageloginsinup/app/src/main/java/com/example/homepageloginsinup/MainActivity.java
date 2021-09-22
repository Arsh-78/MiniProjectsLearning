package com.example.homepageloginsinup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button signUp;
    Button signIN;
    EditText enemail;
    EditText enpassword;
    FirebaseAuth firebaseAuth;




    public void Onsignup(View view)
    {
        startActivity(new Intent(getApplicationContext(),SignUp.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = findViewById(R.id.signUp);
        signIN=findViewById(R.id.signIn);
        enemail=findViewById(R.id.siginemail);
        enpassword=findViewById(R.id.signinpassword);
        firebaseAuth=FirebaseAuth.getInstance();

        signIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=enemail.getText().toString();
                String password = enpassword.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    enemail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password) || password.length()<8)
                {
                    enpassword.setError("Invalid Password ,Use Some other values");
                }

                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,"Sign In Succesful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Homepage.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Some Error Occured,try again or register an account", Toast.LENGTH_LONG).show();

                        }
                    }
                });

            }
        });
    }
}