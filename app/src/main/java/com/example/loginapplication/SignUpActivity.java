package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {


    private EditText eUsername;
    private EditText ePassword;
    private EditText eCpassword;
    private Button eSignup;

    DBHelper dbHelper=new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        eUsername=findViewById(R.id.etUsername);
        ePassword=findViewById(R.id.etPasswordsignup);
        eCpassword=findViewById(R.id.etPasswordconfirm);
        eSignup=findViewById(R.id.btnSignup);

        eSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername=eUsername.getText().toString();
                String inputPassword=ePassword.getText().toString();
                String inputConPassword=eCpassword.getText().toString();

                if (inputUsername.isEmpty() || inputPassword.isEmpty() || inputConPassword.isEmpty()){
                    Toast.makeText(SignUpActivity.this,"Please Enter all the details!!!",Toast.LENGTH_SHORT).show();

                } else {
                    if (inputPassword.equals(inputConPassword)){
                        Boolean checkuser=dbHelper.checkUsername(inputUsername);
                        if (checkuser==false){
                            Boolean insertuser=dbHelper.insertData(inputUsername,inputPassword);
                            if (insertuser) {
                                Toast.makeText(SignUpActivity.this, "registered successfully!!!", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(getApplicationContext(),HomePageActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(SignUpActivity.this, "registration failed please try again!!!", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(SignUpActivity.this, "user already exists!!!", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SignUpActivity.this, "password doesnot match!!!", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });
    }
}