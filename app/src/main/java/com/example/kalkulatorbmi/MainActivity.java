
package com.example.kalkulatorbmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight, etHeight;
    private RadioGroup rgGender;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        rgGender = findViewById(R.id.rgGender);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> calculateBMI());
    }

    private void calculateBMI() {

        double weight = Double.parseDouble(
                etWeight.getText().toString().trim());

        double height = Double.parseDouble(
                etHeight.getText().toString().trim());

        height = height / 100.0;

        double bmi = weight / (height * height);

        tvResult.setText("Twoje BMI: " + bmi);
    }
}
