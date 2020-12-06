package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText username;
    Button reset;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        username=findViewById(R.id.tvForgotusername);
        reset=findViewById(R.id.btnResetpassword);
        dbHelper=new DBHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                Boolean checkuser= dbHelper.checkUsername(user);
                if(checkuser){
                    Intent intent= new Intent(getApplicationContext(),ResetActivity.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                }else {
                    Toast.makeText(ForgotPasswordActivity.this,"user does not exist",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}