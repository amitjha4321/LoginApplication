package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    TextView username;
    EditText password, repassword;
    //EditText ;
    Button confirm;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

       // username = findViewById(R.id.tvForgotusername);
        username=findViewById(R.id.tvforgetPasswordUsername);
        password=findViewById(R.id.etForgotPassword);
        repassword=findViewById(R.id.etRetypePassword);
        confirm=findViewById(R.id.btnConfirmpassword);
        dbHelper = new DBHelper(this);

        Intent intent= getIntent();
        username.setText(intent.getStringExtra("username"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass= password.getText().toString();
                String repass=repassword.getText().toString();

                if (pass.equals(repass)) {


                    Boolean checkpasswordupdate = dbHelper.updatePassword(user, pass);
                    if (checkpasswordupdate) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(ResetActivity.this, "password reset successfully!!!", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(ResetActivity.this, "password not reset!!!", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(ResetActivity.this, "password doesnot match!!!", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}