package com.jstn.csumb338;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jstn.csumb338.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        binding.CtoFConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertValueFromDisplay();
            }
        });

    }

    private void convertValueFromDisplay() {
        String valueFromDisplay = binding.CtoFEnteredValueeditText.getText().toString();
        double fahrenheit = 0.0;

        if(!valueFromDisplay.isEmpty()) {
            double celsius = Double.parseDouble(valueFromDisplay);
            fahrenheit = Utils.ctof(celsius);
        }
        String roundedF = String.format("%.2f", fahrenheit);
        binding.CtoFConvertedValueTextView.setText(roundedF);
    }
}