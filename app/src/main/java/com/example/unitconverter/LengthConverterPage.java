package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class LengthConverterPage extends AppCompatActivity {

   private String[] lengthItem;
   private Spinner inputSpinner,outputSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_converter_page);

        lengthItem = getResources().getStringArray(R.array.length_spinnerText);
        inputSpinner = findViewById(R.id.lengthInputSpinnerId);
        outputSpinner = findViewById(R.id.lengthOutputSpinnerId);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.length_input_spinner_view,R.id.lengthInputSpinnerViewId,lengthItem);
        inputSpinner.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.length_output_spinner_view,R.id.lengthOutputSpinnerViewId,lengthItem);
        outputSpinner.setAdapter(adapter2);
    }
}