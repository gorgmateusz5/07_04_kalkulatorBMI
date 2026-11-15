
package com.example.kalkulatorbmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
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

    private boolean validateForm() {

        String weightText = etWeight.getText().toString().trim();

        if (weightText.isEmpty()) {
            etWeight.setError("Podaj wagę");
            etWeight.requestFocus();
            return false;
        }

        double weight = Double.parseDouble(weightText);

        if (weight <= 0) {
            etWeight.setError("Waga musi być większa od zera");
            etWeight.requestFocus();
            return false;
        }

        String heightText = etHeight.getText().toString().trim();

        if (heightText.isEmpty()) {
            etHeight.setError("Podaj wzrost");
            etHeight.requestFocus();
            return false;
        }

        int height = Integer.parseInt(heightText);

        if (height <= 0) {
            etHeight.setError("Wzrost musi być większy od zera");
            etHeight.requestFocus();
            return false;
        }

        if (height > 300) {
            etHeight.setError("Wzrost nie może przekraczać 300 cm");
            etHeight.requestFocus();
            return false;
        }

        if (rgGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this,
                    "Wybierz płeć",
                    Toast.LENGTH_SHORT).show();
            rgGender.requestFocus();
            return false;
        }

        return true;
    }


    private void calculateBMI() {

        if (!validateForm()) {
            return;
        }

        double weight = Double.parseDouble(
                etWeight.getText().toString().trim());

        double height = Double.parseDouble(
                etHeight.getText().toString().trim());

        height = height / 100.0;

        double bmi = weight / (height * height);

        tvResult.setText("Twoje BMI: " + bmi);
    }

}
