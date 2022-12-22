package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupPage extends AppCompatActivity {
    TextInputLayout fullname_var,username_var,email_var,password_var;
    Button signupBtn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        signupBtn = findViewById(R.id.signupBtnId);

        fullname_var = findViewById(R.id.fullnameFieldId);
        username_var = findViewById(R.id.usernameTextFieldId);
        email_var = findViewById(R.id.emailFieldId);
        password_var = findViewById(R.id.passwordTextFieldId);


        signupBtn.setOnClickListener(view -> {

            String fullname_ = fullname_var.getEditText().getText().toString();
            String username_ = username_var.getEditText().getText().toString();
            String email_ = email_var.getEditText().getText().toString();
            String password_ = password_var.getEditText().getText().toString();

            if(!fullname_.isEmpty()){
                fullname_var.setError(null);
                fullname_var.setErrorEnabled(false);
                if(!username_.isEmpty()){
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);
                    if(!email_.isEmpty()){
                        email_var.setError(null);
                        email_var.setErrorEnabled(false);
                        if(!password_.isEmpty()){
                            password_var.setError(null);
                            password_var.setErrorEnabled(false);

                            if(Patterns.EMAIL_ADDRESS.matcher(email_).matches()){

                                firebaseDatabase = FirebaseDatabase.getInstance();
                                reference = firebaseDatabase.getReference("users");

                                String fullname_s = fullname_var.getEditText().getText().toString();
                                String username_s = username_var.getEditText().getText().toString();
                                String email_s = email_var.getEditText().getText().toString();
                                String password_s = password_var.getEditText().getText().toString();

                                StoringData storingData = new StoringData(fullname_s,username_s,email_s,password_s);
                                reference.child(username_s).setValue(storingData);

                                Toast.makeText(getApplicationContext(),"Registration Successful!",Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(getApplicationContext(),LoginPage.class);
                                startActivity(intent);
                                finish();

                            }else{
                                email_var.setError("Invalid email");
                            }

                        }else{
                            password_var.setError("please enter password");
                        }
                    }else{
                        email_var.setError("please enter email");
                    }
                }else{
                    username_var.setError("please enter username");
                }
            }else {
                fullname_var.setError("please enter full name");
            }
        });
    }
}