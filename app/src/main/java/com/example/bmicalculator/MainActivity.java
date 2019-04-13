package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etHeight, etWeight;
    private TextView tvResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = (EditText) findViewById(R.id.etHeight);
        etWeight = (EditText) findViewById(R.id.etWeight);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalculate = (Button) findViewById(R.id.btnCalc);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcBMI();
            }
        });

    }

    private void calcBMI(){
        float weight, height, bmi;
        weight = Float.parseFloat(etWeight.getText().toString().trim());
        height = Float.parseFloat(etHeight.getText().toString().trim());

        bmi = weight/(height * height);

        tvResult.setText(String.valueOf(bmi));

        if(bmi < 18.5){
            Toast.makeText(getApplicationContext(), "UNDERWEIGHT", Toast.LENGTH_SHORT).show();
        }
        else if (bmi > 18.5 && bmi < 25){
            Toast.makeText(getApplicationContext(), "NORMAL WEIGHT", Toast.LENGTH_SHORT).show();
        }
        else if (bmi > 24.9 && bmi < 30){
            Toast.makeText(getApplicationContext(), "OVERWEIGHT", Toast.LENGTH_SHORT).show();
        }
        else if (bmi >= 30){
            Toast.makeText(getApplicationContext(), "OBESITY", Toast.LENGTH_SHORT).show();
        }
    }
}
