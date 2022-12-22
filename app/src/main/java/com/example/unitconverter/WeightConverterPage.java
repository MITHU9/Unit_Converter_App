package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class WeightConverterPage extends AppCompatActivity {

    String[] weightItem;
    Spinner inputSpinner,outputSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter_page);

        weightItem = getResources().getStringArray(R.array.weight_spinnerText);
        inputSpinner = (Spinner) findViewById(R.id.weightInputSpinnerId);
        outputSpinner =(Spinner) findViewById(R.id.weightOutputSpinnerId);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.weight_spinner_text_view,R.id.weightInputSpinnerTextViewId,weightItem);
        inputSpinner.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.weight_output_spinner_view,R.id.weightOutputSpinnerTextViewId,weightItem);
        outputSpinner.setAdapter(adapter2);
    }
}