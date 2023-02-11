package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class LengthConverterPage extends AppCompatActivity {

    String[] lengthItem;
    Spinner inputSpinner,outputSpinner;
    EditText editText;
    TextView textView;
    Button convertBtn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_converter_page);

        convertBtn = findViewById(R.id.lengthConvertBtnId);
        lengthItem = getResources().getStringArray(R.array.length_spinnerText);
        inputSpinner = findViewById(R.id.lengthInputSpinnerId);
        outputSpinner = findViewById(R.id.lengthOutputSpinnerId);
        editText = findViewById(R.id.lengthInputTextId);
        textView = findViewById(R.id.lengthOutputTextId);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.length_input_spinner_view,R.id.lengthInputSpinnerViewId,lengthItem);
        inputSpinner.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.length_output_spinner_view,R.id.lengthOutputSpinnerViewId,lengthItem);
        outputSpinner.setAdapter(adapter2);


        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String item1 = inputSpinner.getSelectedItem().toString();
                String item2 = outputSpinner.getSelectedItem().toString();
                String value = editText.getText().toString();

                if (!value.isEmpty()){
                    Double input_val = Double.valueOf(value);

                    if (item1.equals("Select") || item2.equals("Select")){
                        Toast.makeText(getApplicationContext(),"Please select an item",Toast.LENGTH_SHORT).show();
                    }


                   else {
                        //µm convert

                        if (item1.equals("µm") && item2.equals("µm")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "µm");
                        } else if (item1.equals("µm") && item2.equals("mm")) {
                            Double result = input_val / 1000;
                            textView.setText(result + "mm");
                        } else if (item1.equals("µm") && item2.equals("cm")) {
                            Double result = input_val / 10000;
                            textView.setText(result + "cm");
                        } else if (item1.equals("µm") && item2.equals("dm")) {
                            Double result = input_val / 100000;
                            textView.setText(result + "dm");
                        } else if (item1.equals("µm") && item2.equals("m")) {
                            Double result = input_val / 1000000;
                            textView.setText(result + "m");
                        } else if (item1.equals("µm") && item2.equals("inch")) {
                            Double result = input_val / 25400;
                            textView.setText(result + "inch");
                        } else if (item1.equals("µm") && item2.equals("ft")) {
                            Double result = input_val / 304800;
                            textView.setText(result + "ft");
                        } else if (item1.equals("µm") && item2.equals("mile")) {
                            Double result = input_val / 1609344000;
                            textView.setText(result + "mile");
                        } else if (item1.equals("µm") && item2.equals("km")) {
                            Double result = input_val / 1e9;
                            textView.setText(result + "km");
                        }

                        //mm convert

                        else if (item1.equals("mm") && item2.equals("mm")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "mm");
                        } else if (item1.equals("mm") && item2.equals("µm")) {
                            Double result = input_val * 1000;
                            textView.setText(result + "µm");
                        } else if (item1.equals("mm") && item2.equals("cm")) {
                            Double result = input_val / 10;
                            textView.setText(result + "cm");
                        } else if (item1.equals("mm") && item2.equals("dm")) {
                            Double result = input_val / 100;
                            textView.setText(result + "dm");
                        } else if (item1.equals("mm") && item2.equals("m")) {
                            Double result = input_val / 1000;
                            textView.setText(result + "m");
                        } else if (item1.equals("mm") && item2.equals("inch")) {
                            Double result = input_val / 25.4;
                            textView.setText(result + "inch");
                        } else if (item1.equals("mm") && item2.equals("ft")) {
                            Double result = input_val / 304.8;
                            textView.setText(result + "ft");
                        } else if (item1.equals("mm") && item2.equals("mile")) {
                            Double result = input_val / 1609344;
                            textView.setText(result + "mile");
                        } else if (item1.equals("mm") && item2.equals("km")) {
                            Double result = input_val / 1000000;
                            textView.setText(result + "km");
                        }

                        //cm convert

                        else if (item1.equals("cm") && item2.equals("cm")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "cm");
                        } else if (item1.equals("cm") && item2.equals("µm")) {
                            Double result = input_val * 10000;
                            textView.setText(result + "µm");
                        } else if (item1.equals("cm") && item2.equals("mm")) {
                            Double result = input_val * 10;
                            textView.setText(result + "mm");
                        } else if (item1.equals("cm") && item2.equals("dm")) {
                            Double result = input_val / 10;
                            textView.setText(result + "dm");
                        } else if (item1.equals("cm") && item2.equals("m")) {
                            Double result = input_val / 100;
                            textView.setText(result + "m");
                        } else if (item1.equals("cm") && item2.equals("inch")) {
                            Double result = input_val / 2.54;
                            textView.setText(result + "inch");
                        } else if (item1.equals("cm") && item2.equals("ft")) {
                            Double result = input_val / 30.48;
                            textView.setText(result + "ft");
                        } else if (item1.equals("cm") && item2.equals("mile")) {
                            Double result = input_val / 160900;
                            textView.setText(result + "mile");
                        } else if (item1.equals("cm") && item2.equals("km")) {
                            Double result = input_val / 100000;
                            textView.setText(result + "km");
                        }

                        //dm convert

                        else if (item1.equals("dm") && item2.equals("dm")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "dm");
                        } else if (item1.equals("dm") && item2.equals("µm")) {
                            Double result = input_val * 100000;
                            textView.setText(result + "µm");
                        } else if (item1.equals("dm") && item2.equals("mm")) {
                            Double result = input_val * 100;
                            textView.setText(result + "mm");
                        } else if (item1.equals("dm") && item2.equals("cm")) {
                            Double result = input_val * 10;
                            textView.setText(result + "dm");
                        } else if (item1.equals("dm") && item2.equals("m")) {
                            Double result = input_val / 10;
                            textView.setText(result + "m");
                        } else if (item1.equals("dm") && item2.equals("inch")) {
                            Double result = input_val * 3.937;
                            textView.setText(result + "inch");
                        } else if (item1.equals("dm") && item2.equals("ft")) {
                            Double result = input_val / 3.048;
                            textView.setText(result + "ft");
                        } else if (item1.equals("dm") && item2.equals("mile")) {
                            Double result = input_val / 16090;
                            textView.setText(result + "mile");
                        } else if (item1.equals("dm") && item2.equals("km")) {
                            Double result = input_val / 10000;
                            textView.setText(result + "km");
                        }

                        // meter convert

                        else if (item1.equals("m") && item2.equals("m")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "m");
                        } else if (item1.equals("m") && item2.equals("µm")) {
                            Double result = input_val * 1000000;
                            textView.setText(result + "µm");
                        } else if (item1.equals("m") && item2.equals("mm")) {
                            Double result = input_val * 1000;
                            textView.setText(result + "mm");
                        } else if (item1.equals("m") && item2.equals("cm")) {
                            Double result = input_val * 100;
                            textView.setText(result + "dm");
                        } else if (item1.equals("m") && item2.equals("dm")) {
                            Double result = input_val * 10;
                            textView.setText(result + "dm");
                        } else if (item1.equals("m") && item2.equals("inch")) {
                            Double result = input_val * 39.37;
                            textView.setText(result + "inch");
                        } else if (item1.equals("m") && item2.equals("ft")) {
                            Double result = input_val * 3.281;
                            textView.setText(result + "ft");
                        } else if (item1.equals("m") && item2.equals("mile")) {
                            Double result = input_val / 1609;
                            textView.setText(result + "mile");
                        } else if (item1.equals("m") && item2.equals("km")) {
                            Double result = input_val / 1000;
                            textView.setText(result + "km");
                        }

                        //inch convert

                        else if (item1.equals("inch") && item2.equals("inch")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "inch");
                        } else if (item1.equals("inch") && item2.equals("µm")) {
                            Double result = input_val * 25400;
                            textView.setText(result + "µm");
                        } else if (item1.equals("inch") && item2.equals("mm")) {
                            Double result = input_val * 25.4;
                            textView.setText(result + "mm");
                        } else if (item1.equals("inch") && item2.equals("cm")) {
                            Double result = input_val * 2.54;
                            textView.setText(result + "dm");
                        } else if (item1.equals("inch") && item2.equals("dm")) {
                            Double result = input_val / 3.937;
                            textView.setText(result + "dm");
                        } else if (item1.equals("inch") && item2.equals("m")) {
                            Double result = input_val / 39.37;
                            textView.setText(result + "m");
                        } else if (item1.equals("inch") && item2.equals("ft")) {
                            Double result = input_val / 12;
                            textView.setText(result + "ft");
                        } else if (item1.equals("inch") && item2.equals("mile")) {
                            Double result = input_val / 63360;
                            textView.setText(result + "mile");
                        } else if (item1.equals("inch") && item2.equals("km")) {
                            Double result = input_val / 39370;
                            textView.setText(result + "km");
                        }

                        //foot convert

                        else if (item1.equals("ft") && item2.equals("ft")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "ft");
                        } else if (item1.equals("ft") && item2.equals("µm")) {
                            Double result = input_val * 304800;
                            textView.setText(result + "µm");
                        } else if (item1.equals("ft") && item2.equals("mm")) {
                            Double result = input_val * 304.8;
                            textView.setText(result + "mm");
                        } else if (item1.equals("ft") && item2.equals("cm")) {
                            Double result = input_val * 30.48;
                            textView.setText(result + "dm");
                        } else if (item1.equals("ft") && item2.equals("dm")) {
                            Double result = input_val * 3.048;
                            textView.setText(result + "dm");
                        } else if (item1.equals("ft") && item2.equals("m")) {
                            Double result = input_val / 3.281;
                            textView.setText(result + "m");
                        } else if (item1.equals("ft") && item2.equals("inch")) {
                            Double result = input_val * 12;
                            textView.setText(result + "inch");
                        } else if (item1.equals("ft") && item2.equals("mile")) {
                            Double result = input_val / 5280;
                            textView.setText(result + "mile");
                        } else if (item1.equals("ft") && item2.equals("km")) {
                            Double result = input_val / 3281;
                            textView.setText(result + "km");
                        }

                        //mile convert

                        else if (item1.equals("mile") && item2.equals("mile")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "mile");
                        } else if (item1.equals("mile") && item2.equals("µm")) {
                            Double result = input_val * 1609344000;
                            textView.setText(result + "µm");
                        } else if (item1.equals("mile") && item2.equals("mm")) {
                            Double result = input_val * 1609344;
                            textView.setText(result + "mm");
                        } else if (item1.equals("mile") && item2.equals("cm")) {
                            Double result = input_val * 160900;
                            textView.setText(result + "dm");
                        } else if (item1.equals("mile") && item2.equals("dm")) {
                            Double result = input_val * 16090;
                            textView.setText(result + "dm");
                        } else if (item1.equals("mile") && item2.equals("m")) {
                            Double result = input_val * 1609;
                            textView.setText(result + "m");
                        } else if (item1.equals("mile") && item2.equals("inch")) {
                            Double result = input_val * 63360;
                            textView.setText(result + "inch");
                        } else if (item1.equals("mile") && item2.equals("ft")) {
                            Double result = input_val * 5280;
                            textView.setText(result + "ft");
                        } else if (item1.equals("mile") && item2.equals("km")) {
                            Double result = input_val * 1.609;
                            textView.setText(result + "km");
                        }

                        //km convert

                        else if (item1.equals("km") && item2.equals("km")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "km");
                        } else if (item1.equals("km") && item2.equals("µm")) {
                            Double result = input_val * 1e9;
                            textView.setText(result + "µm");
                        } else if (item1.equals("km") && item2.equals("mm")) {
                            Double result = input_val * 1000000;
                            textView.setText(result + "mm");
                        } else if (item1.equals("km") && item2.equals("cm")) {
                            Double result = input_val * 100000;
                            textView.setText(result + "dm");
                        } else if (item1.equals("km") && item2.equals("dm")) {
                            Double result = input_val * 10000;
                            textView.setText(result + "dm");
                        } else if (item1.equals("km") && item2.equals("m")) {
                            Double result = input_val * 1000;
                            textView.setText(result + "m");
                        } else if (item1.equals("km") && item2.equals("inch")) {
                            Double result = input_val * 39370;
                            textView.setText(result + "inch");
                        } else if (item1.equals("km") && item2.equals("ft")) {
                            Double result = input_val * 3281;
                            textView.setText(result + "ft");
                        } else if (item1.equals("km") && item2.equals("mile")) {
                            Double result = input_val / 1.609;
                            textView.setText(result + "mile");
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