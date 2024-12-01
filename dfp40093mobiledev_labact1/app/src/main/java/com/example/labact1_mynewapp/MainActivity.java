package com.example.labact1_mynewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String nama;
    EditText edName;
    Button btnSubmit;
    TextView txtDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = (EditText) findViewById(R.id.EditText);
        btnSubmit = (Button)findViewById(R.id.Button);
        txtDisplay = (TextView) findViewById(R.id.TextView3);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edName.getText().toString();
                txtDisplay.setText("Your name is: " + nama);
            }
        });
    }
}