package com.example.heartattacksymptoms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}