package com.example.unitconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationBarView extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,historyBtn;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar_view);

        drawerLayout = findViewById(R.id.drawerLayoutId);
        navigationView = findViewById(R.id.navigationViewId);
        toolbar = findViewById(R.id.toolbarId);

        //Button main

        btn1 = findViewById(R.id.weightBtnId);
        btn2 = findViewById(R.id.lengthBtnId);
        btn3 = findViewById(R.id.currencyBtnId);
        btn4 = findViewById(R.id.temperatureBtnId);
        historyBtn = findViewById(R.id.historyBtnId);


        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.mHome){

                    Toast.makeText(NavigationBarView.this, "Clicked", Toast.LENGTH_SHORT).show();

                }else if(id == R.id.mProfile){

                    Toast.makeText(NavigationBarView.this, "Clicked", Toast.LENGTH_SHORT).show();

                }else if(id == R.id.mLogout) {

                        AlertDialog.Builder alertDiologue = new AlertDialog.Builder(NavigationBarView.this);
                        alertDiologue.setTitle("Logout App");
                        alertDiologue.setMessage("Do you want to logout?");
                        alertDiologue.setPositiveButton("Yes" ,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(NavigationBarView.this, LoginPage.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        alertDiologue.setNegativeButton("No" ,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        alertDiologue.show();
                }
                else{
                    Toast.makeText(NavigationBarView.this, "Clicked", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });



        //Button listener


        btn1.setOnClickListener(view -> {
            Intent intent1 = new Intent(NavigationBarView.this,WeightConverterPage.class);
            startActivity(intent1);
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(NavigationBarView.this,LengthConverterPage.class);
                startActivity(intent2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(NavigationBarView.this,CurrencyConverterPage.class);
                startActivity(intent3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(NavigationBarView.this,TemperatureConverterPage.class);
                startActivity(intent4);
            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(NavigationBarView.this,HistoryViewActivityPage.class);
                startActivity(intent5);
            }
        });


    }

    //On BackPressed Listener

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            AlertDialog.Builder alertDiologue = new AlertDialog.Builder(NavigationBarView.this);
            alertDiologue.setTitle("Exit App");
            alertDiologue.setMessage("Do you want to close app?");
            alertDiologue.setPositiveButton("Yes" ,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finishAffinity();
                }
            });
            alertDiologue.setNegativeButton("No" ,new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            alertDiologue.show();
        }
    }
}