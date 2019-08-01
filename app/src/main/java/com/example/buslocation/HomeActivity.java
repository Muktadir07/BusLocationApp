package com.example.buslocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button nearByBusBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        nearByBusBTN=findViewById(R.id.nearbyBusBTN);



    }

    public void showCurrentLocation(View view) {
        Intent intent= new Intent(HomeActivity.this,MapsActivity.class);
        startActivity(intent);
    }


    public void nearbyBusStop(View view) {
        Intent intent= new Intent(HomeActivity.this,BusStopage.class);
        startActivity(intent);
    }
}
