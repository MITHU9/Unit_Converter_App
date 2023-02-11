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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class WeightConverterPage extends AppCompatActivity {

    String[] weightItem;
    Spinner inputSpinner,outputSpinner;
    EditText editText;
    TextView textView;
    Button convertBtn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter_page);

        convertBtn = findViewById(R.id.weightConvertBtnId);
        weightItem = getResources().getStringArray(R.array.weight_spinnerText);
        inputSpinner = (Spinner) findViewById(R.id.weightInputSpinnerId);
        outputSpinner =(Spinner) findViewById(R.id.weightOutputSpinnerId);
        editText = findViewById(R.id.weightInputTextId);
        textView = findViewById(R.id.weightOutputTextId);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.weight_spinner_text_view,R.id.weightInputSpinnerTextViewId,weightItem);
        inputSpinner.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.weight_output_spinner_view,R.id.weightOutputSpinnerTextViewId,weightItem);
        outputSpinner.setAdapter(adapter2);


        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String item1 =  inputSpinner.getSelectedItem().toString();
                String item2 = outputSpinner.getSelectedItem().toString();
                String value = editText.getText().toString();

                if (!value.isEmpty()){
                    Double input_val = Double.valueOf(value);

                    if (item1.equals("Select") || item2.equals("Select")){
                        Toast.makeText(getApplicationContext(), "Please select an item", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        //µg convert

                        if (item1.equals("µg") && item2.equals("µg")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "µg");
                        } else if (item1.equals("µg") && item2.equals("mg")) {
                            Double result = input_val / 1000;
                            textView.setText(result + "mg");
                        } else if (item1.equals("µg") && item2.equals("g")) {
                            Double result = input_val / 1000000;
                            textView.setText(result + "g");
                        } else if (item1.equals("µg") && item2.equals("kg")) {
                            Double result = input_val / 1000000000;
                            textView.setText(result + "kg");
                        } else if (item1.equals("µg") && item2.equals("carat")) {
                            Double result = input_val / 200000;
                            textView.setText(result + "carat");
                        }

                        //mg convert

                        else if (item1.equals("mg") && item2.equals("mg")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "mg");
                        } else if (item1.equals("mg") && item2.equals("µg")) {
                            Double result = input_val * 1000;
                            textView.setText(result + "mg");
                        } else if (item1.equals("mg") && item2.equals("g")) {
                            Double result = input_val / 1000;
                            textView.setText(result + "g");
                        } else if (item1.equals("mg") && item2.equals("kg")) {
                            Double result = input_val / 1000000;
                            textView.setText(result + "kg");
                        } else if (item1.equals("mg") && item2.equals("carat")) {
                            Double result = input_val / 200;
                            textView.setText(result + "carat");
                        }

                        //g convert

                        else if (item1.equals("g") && item2.equals("g")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "g");
                        } else if (item1.equals("g") && item2.equals("µg")) {
                            Double result = input_val * 1000000;
                            textView.setText(result + "µg");
                        } else if (item1.equals("g") && item2.equals("mg")) {
                            Double result = input_val * 1000;
                            textView.setText(result + "mg");
                        } else if (item1.equals("g") && item2.equals("kg")) {
                            Double result = input_val / 1000;
                            textView.setText(result + "kg");
                        } else if (item1.equals("g") && item2.equals("carat")) {
                            Double result = input_val * 5;
                            textView.setText(result + "carat");
                        }

                        //kg convert

                        else if (item1.equals("kg") && item2.equals("kg")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "kg");
                        } else if (item1.equals("kg") && item2.equals("µg")) {
                            Double result = input_val * 1e9;
                            textView.setText(result + "µg");
                        } else if (item1.equals("kg") && item2.equals("mg")) {
                            Double result = input_val * 1e6;
                            textView.setText(result + "mg");
                        } else if (item1.equals("kg") && item2.equals("g")) {
                            Double result = input_val * 1000;
                            textView.setText(result + "g");
                        } else if (item1.equals("kg") && item2.equals("carat")) {
                            Double result = input_val * 5000;
                            textView.setText(result + "carat");
                        }

                        //carat convert

                        else if (item1.equals("carat") && item2.equals("carat")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "carat");
                        } else if (item1.equals("carat") && item2.equals("µg")) {
                            Double result = input_val * 200000;
                            textView.setText(result + "µg");
                        } else if (item1.equals("carat") && item2.equals("mg")) {
                            Double result = input_val * 200;
                            textView.setText(result + "mg");
                        } else if (item1.equals("carat") && item2.equals("kg")) {
                            Double result = input_val / 5000;
                            textView.setText(result + "kg");
                        } else if (item1.equals("carat") && item2.equals("g")) {
                            Double result = input_val / 5;
                            textView.setText(result + "g");
                        }

                        //Storing data

                        firebaseDatabase = FirebaseDatabase.getInstance();
                        reference = firebaseDatabase.getReference().child("appdata");

                        String item_1 = inputSpinner.getSelectedItem().toString();
                        String item_2 = outputSpinner.getSelectedItem().toString();
                        String value_ = editText.getText().toString();
                        String result_ = textView.getText().toString();
                        String calValue = "From" + " " + value_ + item_1 + " " + "To" + " " + item_2 + " " + "=" + " " + result_;

                        String id = reference.push().getKey();
                        StoringAppData storingAppData = new StoringAppData(calValue);
                        reference.child(id).setValue(storingAppData);

                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Enter some value", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}