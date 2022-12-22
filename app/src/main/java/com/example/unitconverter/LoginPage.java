package com.example.unitconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginPage extends AppCompatActivity {

    private Button loginBtn,createNewBtn;
    TextInputLayout username_var,password_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginBtn = findViewById(R.id.loginBtnId);
        createNewBtn = findViewById(R.id.createAccountBtnId);

        username_var = findViewById(R.id.usernameFieldId);
        password_var = findViewById(R.id.passwordFieldId);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username_ = username_var.getEditText().getText().toString();
                String password_ = password_var.getEditText().getText().toString();
                if(!username_.isEmpty()){
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);
                    if (!password_.isEmpty()){
                        password_var.setError(null);
                        password_var.setErrorEnabled(false);

                        final String username_data = username_var.getEditText().getText().toString();
                        final  String password_data = password_var.getEditText().getText().toString();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebaseDatabase.getReference("users");

                        Query check_username = databaseReference.orderByChild("username").equalTo(username_data);

                        check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    username_var.setError(null);
                                    username_var.setErrorEnabled(false);

                                    String check_password = snapshot.child(username_data).child("password").getValue(String.class);

                                    if(check_password.equals(password_data)){
                                        password_var.setError(null);
                                        password_var.setErrorEnabled(false);

                                        Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_LONG).show();
                                        Intent intent1 = new Intent(LoginPage.this,MainActivity.class);
                                        startActivity(intent1);
                                        finish();

                                    }else{
                                        password_var.setError("wrong password!");
                                    }


                                }else{
                                    username_var.setError("user does not exists!");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }else {
                        password_var.setError("please enter password");
                    }
                }else {
                    username_var.setError("please enter username");
                }

            }
        });

        createNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(LoginPage.this,SignupPage.class);
                startActivity(intent2);
            }
        });
    }
}