package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TemperatureConverterPage extends AppCompatActivity {

     String[] temperatureItem;
     Spinner inputSpinner,outputSpinner;
     EditText editText;
     TextView textView;
     Button convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter_page);

        convertBtn = findViewById(R.id.temperatureConvertBtnId);
        temperatureItem = getResources().getStringArray(R.array.temperature_spinnerText);
        inputSpinner = findViewById(R.id.temperatureInputSpinnerId);
        outputSpinner = findViewById(R.id.temperatureOutputSpinnerId);
        editText = findViewById(R.id.temperatureInputTextId);
        textView = findViewById(R.id.temperatureOutputTextId);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.temperature_input_spinner_view, R.id.temperatureInputSpinnerViewId, temperatureItem);
        inputSpinner.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.temperature_output_spinner_view, R.id.temperatureOutputSpinnerViewId, temperatureItem);
        outputSpinner.setAdapter(adapter2);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value1 = inputSpinner.getSelectedItem().toString();
                String value2 = outputSpinner.getSelectedItem().toString();
                String value = editText.getText().toString();

                if (!value.isEmpty()){

                    Double input_val = Double.valueOf(value);

                    if(value1.equals("Select") || value2.equals("Select")) {
                        Toast.makeText(getApplicationContext(), "Please select an item", Toast.LENGTH_SHORT).show();
                    }
                        //Kelvin calculation

                    else if(value1.equals("K") && value2.equals("°F")){
                            Double result = (input_val-273.15) * 9/5+32;
                            textView.setText(new DecimalFormat("##.##").format(result) + "°F");
                        }
                        else if(value1.equals("K") && value2.equals("°C")){
                            Double result = (input_val-273.15);
                            textView.setText(new DecimalFormat("##.##").format(result) + "°C");
                        }
                        else if(value1.equals("K") && value2.equals("K")){
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "K");
                        }

                        //Fahrenheit calculation

                        if(value1.equals("°F") && value2.equals("K")){
                            Double result = (input_val-32) * 5/9+273.15;
                            textView.setText(new DecimalFormat("##.##").format(result) + "K");
                        }
                        else if(value1.equals("°F") && value2.equals("°C")){
                            Double result = (input_val-32) * 5/9;
                            textView.setText(new DecimalFormat("##.##").format(result) + "°C");
                        }
                        else if(value1.equals("°F") && value2.equals("°F")){
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "°F");
                        }

                        // Celsius calculation

                        if(value1.equals("°C") && value2.equals("K")){
                            Double result = input_val + 273.15;
                            textView.setText(new DecimalFormat("##.##").format(result) + "K");
                        }
                        else if(value1.equals("°C") && value2.equals("°F")){
                            Double result = (input_val * 9/5) + 32;
                            textView.setText(new DecimalFormat("##.##").format(result) + "°F");
                        }
                        else if(value1.equals("°C") && value2.equals("°C")){
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "°C");
                        }
                    }else{
                    Toast.makeText(getApplicationContext(), "Enter some value!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}