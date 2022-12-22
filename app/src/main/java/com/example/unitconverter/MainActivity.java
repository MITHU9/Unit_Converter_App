package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

     Button btn1,btn2,btn3,btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.weightBtnId);
        btn2 = findViewById(R.id.lengthBtnId);
        btn3 = findViewById(R.id.currencyBtnId);
        btn4 = findViewById(R.id.temperatureBtnId);


        btn1.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this,WeightConverterPage.class);
            startActivity(intent1);
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,LengthConverterPage.class);
                startActivity(intent2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this,CurrencyConverterPage.class);
                startActivity(intent3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this,TemperatureConverterPage.class);
                startActivity(intent4);
            }
        });
    }
}