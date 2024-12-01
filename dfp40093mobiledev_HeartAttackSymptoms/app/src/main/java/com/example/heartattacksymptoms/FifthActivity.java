package com.example.heartattacksymptoms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}