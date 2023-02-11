package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

public class CurrencyConverterPage extends AppCompatActivity {

    String[] currencyItem;
    Spinner inputSpinner,outputSpinner;
    EditText editText;
    TextView textView;
    Button convertBtn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter_page);

        convertBtn = findViewById(R.id.currencyConvertBtnId);
        currencyItem = getResources().getStringArray(R.array.currency_spinnerText);
        inputSpinner = findViewById(R.id.currencyInputSpinnerId);
        outputSpinner = findViewById(R.id.currencyOutputSpinnerId);
        editText = findViewById(R.id.currencyInputTextId);
        textView = findViewById(R.id.currencyOutputTextId);


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.currency_input_spinner_view,R.id.currencyInputSpinnerViewId,currencyItem);
        inputSpinner.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.currency_output_spinner_view,R.id.currencyOutputSpinnerViewId,currencyItem);
        outputSpinner.setAdapter(adapter2);


        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String item1 = inputSpinner.getSelectedItem().toString();
                String item2 = outputSpinner.getSelectedItem().toString();
                String value = editText.getText().toString();

                if (!value.isEmpty()){
                    Double input_val = Double.valueOf(value);

                    if(item1.equals("Select") || item2.equals("Select")) {
                        Toast.makeText(getApplicationContext(), "Please select an item", Toast.LENGTH_SHORT).show();
                    }


                    else {
                        //BD currency convert

                      if (item1.equals("BDT") && item2.equals("BDT")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("BDT") && item2.equals("USD")) {
                            Double result = input_val / 105.97;
                            textView.setText(new DecimalFormat("##.##").format(result) + "$");
                        } else if (item1.equals("BDT") && item2.equals("UK")) {
                            Double result = input_val / 128.65;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Pound");
                        } else if (item1.equals("BDT") && item2.equals("Dubai")) {
                            Double result = input_val / 28.86;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dirham");
                        } else if (item1.equals("BDT") && item2.equals("Malaysia")) {
                            Double result = input_val / 23.88;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Ringgit");
                        } else if (item1.equals("BDT") && item2.equals("India")) {
                            Double result = input_val / 1.28;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("BDT") && item2.equals("Pakistan")) {
                            Double result = input_val * 2.13;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("BDT") && item2.equals("Qatar")) {
                            Double result = input_val / 29.10;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rial");
                        } else if (item1.equals("BDT") && item2.equals("Kuwait")) {
                            Double result = input_val / 346.02;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dinar");
                        }

                        //Dollar currency convert

                        else if (item1.equals("USD") && item2.equals("BDT")) {
                            Double result = input_val * 105.97;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("USD") && item2.equals("USD")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "$");
                        } else if (item1.equals("USD") && item2.equals("UK")) {
                            Double result = input_val / 1.21;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Pound");
                        } else if (item1.equals("USD") && item2.equals("Dubai")) {
                            Double result = input_val * 3.67;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dirham");
                        } else if (item1.equals("USD") && item2.equals("Malaysia")) {
                            Double result = input_val * 4.44;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Ringgit");
                        } else if (item1.equals("USD") && item2.equals("India")) {
                            Double result = input_val * 82.84;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("USD") && item2.equals("Pakistan")) {
                            Double result = input_val * 226.21;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("USD") && item2.equals("Qatar")) {
                            Double result = input_val * 3.64;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rial");
                        } else if (item1.equals("USD") && item2.equals("Kuwait")) {
                            Double result = input_val / 3.26;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dinar");
                        }

                        //British currency convert

                        else if (item1.equals("UK") && item2.equals("BDT")) {
                            Double result = input_val * 128.65;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("UK") && item2.equals("USD")) {
                            Double result = input_val * 1.21;
                            textView.setText(new DecimalFormat("##.##").format(result) + "$");
                        } else if (item1.equals("UK") && item2.equals("UK")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Pound");
                        } else if (item1.equals("UK") && item2.equals("Dubai")) {
                            Double result = input_val * 4.45;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dirham");
                        } else if (item1.equals("UK") && item2.equals("Malaysia")) {
                            Double result = input_val * 5.38;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Ringgit");
                        } else if (item1.equals("UK") && item2.equals("India")) {
                            Double result = input_val * 100.38;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("UK") && item2.equals("Pakistan")) {
                            Double result = input_val * 273.84;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("UK") && item2.equals("Qatar")) {
                            Double result = input_val * 4.41;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rial");
                        } else if (item1.equals("UK") && item2.equals("Kuwait")) {
                            Double result = input_val / 2.70;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dinar");
                        }

                        //Dubai currency convert

                        else if (item1.equals("Dubai") && item2.equals("BDT")) {
                            Double result = input_val * 28.86;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("Dubai") && item2.equals("USD")) {
                            Double result = input_val / 3.67;
                            textView.setText(new DecimalFormat("##.##").format(result) + "$");
                        } else if (item1.equals("Dubai") && item2.equals("UK")) {
                            Double result = input_val / 4.45;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Pound");
                        } else if (item1.equals("Dubai") && item2.equals("Dubai")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dirham");
                        } else if (item1.equals("Dubai") && item2.equals("Malaysia")) {
                            Double result = input_val * 1.21;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Ringgit");
                        } else if (item1.equals("Dubai") && item2.equals("India")) {
                            Double result = input_val * 22.57;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Dubai") && item2.equals("Pakistan")) {
                            Double result = input_val * 61.59;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Dubai") && item2.equals("Qatar")) {
                            Double result = input_val / 1.01;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rial");
                        } else if (item1.equals("Dubai") && item2.equals("Kuwait")) {
                            Double result = input_val / 11.99;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dinar");
                        }

                        // Malaysia currency convert

                        else if (item1.equals("Malaysia") && item2.equals("BDT")) {
                            Double result = input_val * 23.89;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("Malaysia") && item2.equals("USD")) {
                            Double result = input_val / 4.44;
                            textView.setText(new DecimalFormat("##.##").format(result) + "$");
                        } else if (item1.equals("Malaysia") && item2.equals("UK")) {
                            Double result = input_val / 5.37;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Pound");
                        } else if (item1.equals("Malaysia") && item2.equals("Dubai")) {
                            Double result = input_val / 1.21;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dirham");
                        } else if (item1.equals("Malaysia") && item2.equals("Malaysia")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Ringgit");
                        } else if (item1.equals("Malaysia") && item2.equals("India")) {
                            Double result = input_val * 18.69;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Malaysia") && item2.equals("Pakistan")) {
                            Double result = input_val * 50.98;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Malaysia") && item2.equals("Qatar")) {
                            Double result = input_val / 1.22;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rial");
                        } else if (item1.equals("Malaysia") && item2.equals("Kuwait")) {
                            Double result = input_val / 14.48;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dinar");
                        }

                        //Indian Currency convert

                        else if (item1.equals("India") && item2.equals("BDT")) {
                            Double result = input_val * 1.28;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("India") && item2.equals("USD")) {
                            Double result = input_val / 82.92;
                            textView.setText(new DecimalFormat("##.##").format(result) + "$");
                        } else if (item1.equals("India") && item2.equals("UK")) {
                            Double result = input_val / 100.38;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Pound");
                        } else if (item1.equals("India") && item2.equals("Dubai")) {
                            Double result = input_val / 22.58;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dirham");
                        } else if (item1.equals("India") && item2.equals("Malaysia")) {
                            Double result = input_val / 18.68;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Ringgit");
                        } else if (item1.equals("India") && item2.equals("India")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("India") && item2.equals("Pakistan")) {
                            Double result = input_val * 2.73;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("India") && item2.equals("Qatar")) {
                            Double result = input_val / 22.78;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("India") && item2.equals("Kuwait")) {
                            Double result = input_val / 270.65;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dinar");
                        }

                        //Pakistani Currency convert

                        else if (item1.equals("Pakistan") && item2.equals("BDT")) {
                            Double result = input_val / 2.14;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("Pakistan") && item2.equals("USD")) {
                            Double result = input_val / 226.20;
                            textView.setText(new DecimalFormat("##.##").format(result) + "$");
                        } else if (item1.equals("Pakistan") && item2.equals("UK")) {
                            Double result = input_val / 273.91;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Pound");
                        } else if (item1.equals("Pakistan") && item2.equals("Dubai")) {
                            Double result = input_val / 61.59;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dirham");
                        } else if (item1.equals("Pakistan") && item2.equals("Malaysia")) {
                            Double result = input_val / 50.98;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Ringgit");
                        } else if (item1.equals("Pakistan") && item2.equals("India")) {
                            Double result = input_val / 2.73;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Pakistan") && item2.equals("Pakistan")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Pakistan") && item2.equals("Qatar")) {
                            Double result = input_val / 62.13;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rial");
                        } else if (item1.equals("Pakistan") && item2.equals("Kuwait")) {
                            Double result = input_val / 738.38;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dinar");
                        }

                        //Qatar Currency convert

                        else if (item1.equals("Qatar") && item2.equals("BDT")) {
                            Double result = input_val * 29.11;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("Qatar") && item2.equals("USD")) {
                            Double result = input_val / 3.64;
                            textView.setText(new DecimalFormat("##.##").format(result) + "$");
                        } else if (item1.equals("Qatar") && item2.equals("UK")) {
                            Double result = input_val / 4.41;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Pound");
                        } else if (item1.equals("Qatar") && item2.equals("Dubai")) {
                            Double result = input_val * 1.01;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dirham");
                        } else if (item1.equals("Qatar") && item2.equals("Malaysia")) {
                            Double result = input_val * 1.22;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Ringgit");
                        } else if (item1.equals("Qatar") && item2.equals("India")) {
                            Double result = input_val * 22.77;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Qatar") && item2.equals("Pakistan")) {
                            Double result = input_val * 62.13;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Qatar") && item2.equals("Qatar")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rial");
                        } else if (item1.equals("Qatar") && item2.equals("Kuwait")) {
                            Double result = input_val / 11.89;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dinar");
                        }

                        // Kuwait Currency convert

                        else if (item1.equals("Kuwait") && item2.equals("BDT")) {
                            Double result = input_val * 346.02;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Tk");
                        } else if (item1.equals("Kuwait") && item2.equals("USD")) {
                            Double result = input_val * 3.26;
                            textView.setText(new DecimalFormat("##.##").format(result) + "$");
                        } else if (item1.equals("Kuwait") && item2.equals("UK")) {
                            Double result = input_val * 2.70;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Pound");
                        } else if (item1.equals("Kuwait") && item2.equals("Dubai")) {
                            Double result = input_val * 11.99;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dirham");
                        } else if (item1.equals("Kuwait") && item2.equals("Malaysia")) {
                            Double result = input_val * 14.49;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Ringgit");
                        } else if (item1.equals("Kuwait") && item2.equals("India")) {
                            Double result = input_val * 270.69;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Kuwait") && item2.equals("Pakistan")) {
                            Double result = input_val * 738.46;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rupee");
                        } else if (item1.equals("Kuwait") && item2.equals("Qatar")) {
                            Double result = input_val * 11.89;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Rial");
                        } else if (item1.equals("Kuwait") && item2.equals("Kuwait")) {
                            Double result = input_val;
                            textView.setText(new DecimalFormat("##.##").format(result) + "Dinar");
                        }

                        //Storing data

                        firebaseDatabase = FirebaseDatabase.getInstance();
                        reference = firebaseDatabase.getReference().child("appdata");

                        DatabaseReference databaseReference = firebaseDatabase.getReference().child("users");

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
                    Toast.makeText(getApplicationContext(),"Enter some value!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}