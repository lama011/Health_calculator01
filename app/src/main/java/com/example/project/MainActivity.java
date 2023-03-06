package com.example.project;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc  = (Button) findViewById(R.id.button);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }

        });
    }
}