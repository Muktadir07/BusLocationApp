package com.example.buslocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar progressbarID;
    private int progressbar=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressbarID=findViewById(R.id.progressbarID);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                startThread();
                landingPage();

            }
        });
        thread.start();
    }

    private void landingPage() {
        Intent intent= new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(intent);
        finish();

    }


    private void startThread() {
        for(progressbar=50;progressbar<=100;progressbar=progressbar+50){
            try {
                Thread.sleep(1000);
                progressbarID.setProgress(progressbar);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
