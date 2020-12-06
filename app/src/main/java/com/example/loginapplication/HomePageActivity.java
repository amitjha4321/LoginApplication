package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePageActivity extends AppCompatActivity {

    private Button eLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        eLogout=findViewById(R.id.btnLogout);
        eLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(HomePageActivity.this,"Logged Out Successfully", Toast.LENGTH_LONG).show();

            }
        });
    }
}