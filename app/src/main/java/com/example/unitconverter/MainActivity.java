//package com.example.unitconverter;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.google.android.material.navigation.NavigationView;
//
//public class MainActivity extends AppCompatActivity {
//
//     Button btn1,btn2,btn3,btn4,historyBtn;
//
////    DrawerLayout drawerLayout;
////    NavigationView navigationView;
////    ActionBarDrawerToggle toggle;
////
////    ImageView imageMenu;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        btn1 = findViewById(R.id.weightBtnId);
//        btn2 = findViewById(R.id.lengthBtnId);
//        btn3 = findViewById(R.id.currencyBtnId);
//        btn4 = findViewById(R.id.temperatureBtnId);
//        historyBtn = findViewById(R.id.historyBtnId);
//
//
//
//        //Navbar Style
//
////      // Navagation Drawar------------------------------
////
////        drawerLayout = findViewById(R.id.drawer_layout);
////        navigationView = findViewById(R.id.nav_View);
////        imageMenu = findViewById(R.id.imageMenu);
////
////        toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.open, R.string.close);
////        drawerLayout.addDrawerListener(toggle);
////        toggle.syncState();
////        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////
////        // Drawar click event
////        // Drawer item Click event ------
////        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
////            @Override
////            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
////
////                switch (item.getItemId()) {
////                    case R.id.mHome:
////                        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
////                        drawerLayout.closeDrawers();
////                        break;
////
////                    case R.id.mShare:
////                        Toast.makeText(getApplicationContext()
////                                , "Facebook", Toast.LENGTH_SHORT).show();
////                        drawerLayout.closeDrawers();
////                        break;
////
////                }
////
////                return false;
////            }
////        });
////        //------------------------------
////
////        // ------------------------
////        // App Bar Click Event
////        imageMenu = findViewById(R.id.imageMenu);
////
////        imageMenu.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                // Code Here
////                drawerLayout.openDrawer(GravityCompat.START);
////            }
////        });
////
////
////        // ------------------------
//
//
//
//          //Button Style
//
//        btn1.setOnClickListener(view -> {
//            Intent intent1 = new Intent(MainActivity.this,WeightConverterPage.class);
//            startActivity(intent1);
//        });
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2 = new Intent(MainActivity.this,LengthConverterPage.class);
//                startActivity(intent2);
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3 = new Intent(MainActivity.this,CurrencyConverterPage.class);
//                startActivity(intent3);
//            }
//        });
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent4 = new Intent(MainActivity.this,TemperatureConverterPage.class);
//                startActivity(intent4);
//            }
//        });
//
//        historyBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent5 = new Intent(MainActivity.this,HistoryViewActivityPage.class);
//                startActivity(intent5);
//            }
//        });
//    }
//}