package com.example.unitconverter;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HistoryViewActivityPage extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    RecyclerView historyView;
    List<StoringAppData> appdataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view_page);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("appdata");

        appdataList = new ArrayList<>();
        historyView = findViewById(R.id.appdataListViewId);

    }

    @Override
    protected void onStart() {
        super.onStart();

        AppDataList adapter = new AppDataList(HistoryViewActivityPage.this,appdataList);
        historyView.setAdapter(adapter);
        historyView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                 appdataList.clear();
                for( DataSnapshot dataSnapshot: snapshot.getChildren()){

                   StoringAppData storingAppData = dataSnapshot.getValue(StoringAppData.class);
                   appdataList.add(storingAppData);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
}