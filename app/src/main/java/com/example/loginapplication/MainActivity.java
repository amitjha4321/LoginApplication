package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private Button eSignup;
    private TextView eAttemptsInfo;
    private TextView eforgotPass;

//    private String Username="Admin";
//    private String Password="12345678";

    //private boolean isValid= false;

    private int counter=5;



 DBHelper dbHelper=new DBHelper(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName= findViewById(R.id.etName);
        ePassword= findViewById(R.id.etPassword);
        eLogin=findViewById(R.id.btnLogin);
        eSignup=findViewById(R.id.btnSignUp);
        eAttemptsInfo=findViewById(R.id.tvAttemptsInfo);
        eforgotPass=findViewById(R.id.tvforgotpassword);

        //set an onclick listener on the button
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName=eName.getText().toString();
                String inputPassword= ePassword.getText().toString();
                if (inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter all The Details Correctly!",Toast.LENGTH_LONG).show();
                }else{
                    //isValid=validate(inputName,inputPassword);
                    //if (!isValid){
                    if(!dbHelper.checkUsernamePassword(inputName,inputPassword)){
                        counter--;
                        Toast.makeText(MainActivity.this,"Incorrect Credentials!",Toast.LENGTH_LONG).show();

                        eAttemptsInfo.setText("No. of Attempts remaining: " + counter);
                        if (counter==0){
                            eLogin.setEnabled(false);
                        }
                    }else {
                        Toast.makeText(MainActivity.this,"Login successful!",Toast.LENGTH_LONG).show();
                        //add the code to go to the homepage/other activity page
                        Intent intent=new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        eSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"redirecting to signup page!",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        eforgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
//    private boolean validate(String name, String password){
//        if (name.equals(Username) && password.equals(Password)){
//            return true;
//        }
//        return false;
//    }


}