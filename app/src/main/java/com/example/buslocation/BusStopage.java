package com.example.buslocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BusStopage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_stopage);
    }

    public void addBusInfo(View view) {
        Intent intent= new Intent(BusStopage.this,BusInformation.class);
        startActivity(intent);
    }
}
