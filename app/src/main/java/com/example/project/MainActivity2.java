package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.text.*;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity2 extends AppCompatActivity {
    Button send;
    EditText name,height,weight,Age,status;
    TextView  result_cal,result_wa,result_BMI;
    float w,l ,cal,re_wa,n1,BMI,Height_in_metre;
    int age;
    String res;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=(EditText)findViewById(R.id.editTextTextPersonName);
        height=(EditText)findViewById(R.id.editTextTextPersonName2);
        weight=(EditText)findViewById(R.id.editTextTextPersonName3);
        Age=(EditText)findViewById(R.id.editTextTextPersonName4);
        send=(Button)findViewById(R.id.button2);
        result_cal=(TextView) findViewById(R.id.textView);
        result_wa= (TextView) findViewById(R.id.textView2);
        result_BMI=(TextView) findViewById(R.id.textView3);
        status=(EditText)findViewById(R.id.status);

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                l = Float.parseFloat(height.getText() + "");
                w = Float.parseFloat(weight.getText() + "");

                result_cal.setText(null);
                result_wa.setText(null);
                result_BMI.setText(null);
                status.setText(null);


                //calculate calories
                age = Integer.parseInt(Age.getText() + "");
                cal = (float) (447.593 + (9.247 * w) + (3.098 * l) - (4.330 * age) -
                        161);
                result_cal.setText(String.valueOf(cal));


                //calculate water need
                n1 = Integer.parseInt(weight.getText().toString());
                re_wa = n1 * (30) / (1000);
                result_wa.setText(String.valueOf(re_wa));


                //calculate BMI
                Height_in_metre = l / 100;
                BMI = w / (Height_in_metre * Height_in_metre);

                result_BMI.setText(String.valueOf(BMI));

                //the status text as per the bmi conditions
                if (BMI < 18.5) {
                    status.setText(String.valueOf("Under Weight"));
                } else if (BMI >= 18.5 && BMI < 24.9) {
                    status.setText(String.valueOf("Healthy"));
                } else if (BMI >= 24.9 && BMI < 30) {
                    status.setText(String.valueOf("Overweight"));
                } else if (BMI >= 30) {
                    status.setText(String.valueOf("Suffering from Obesity"));
                }


            }
        });
    }}