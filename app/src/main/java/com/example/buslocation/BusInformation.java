package com.example.buslocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BusInformation extends AppCompatActivity {
    private EditText busNameET,busPositionET,arival_or_depET;
    private Button addBusInfoBTN;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference busInfoDB;

    private Spinner spinner;
    ValueEventListener valueEventListener;
    ArrayAdapter<String> adapter;
    ArrayList<String> spinnerDataList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_information);

        data_initialize();
        onClicked();
        busNameData();
    }

    private void data_initialize() {

        firebaseDatabase= FirebaseDatabase.getInstance();
        busInfoDB=FirebaseDatabase.getInstance().getReference().child("BusInfoDatabase");


        busNameET=findViewById(R.id.busNameET);
        busPositionET=findViewById(R.id.busPositionET);
        arival_or_depET=findViewById(R.id.arival_or_depET);
        addBusInfoBTN=findViewById(R.id.addBusInfoBTN);

        spinner=findViewById(R.id.butNameSpinner);
        spinnerDataList = new ArrayList<>();
        adapter= new ArrayAdapter<String>(BusInformation.this,
                R.layout.support_simple_spinner_dropdown_item,spinnerDataList);
        spinner.setAdapter(adapter);
    }

    private void onClicked() {
        addBusInfoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String busName= busNameET.getText().toString();
                String busPosition= busPositionET.getText().toString();
                String arival_or_departure= arival_or_depET.getText().toString();


                saveToDataBase(new BusInfo(busName,busPosition,arival_or_departure));

            }
        });
    }

    private void saveToDataBase(BusInfo busInfo) {


        String busID= busInfoDB.push().getKey();
        busInfo.setBusID(busID);
        busInfoDB.child(busID).setValue(busInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    spinnerDataList.clear();
                    busNameData();
                    adapter.notifyDataSetChanged();
                    Toast.makeText(BusInformation.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(BusInformation.this, "Error connecting databse", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void busNameData(){
        valueEventListener=busInfoDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot item:dataSnapshot.getChildren()){
                    spinnerDataList.add(item.child("busName").getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
