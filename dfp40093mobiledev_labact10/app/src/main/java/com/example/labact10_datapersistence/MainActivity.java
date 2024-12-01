package com.example.labact10_datapersistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    int numToStore, numToDisplay;

    //declare the file name
    public static final String SP_FileName = "com.example.labact10_datapersistence.sp_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextNumber);
        textView = (TextView) findViewById(R.id.txtDisplay);
    }

    //create a method to store
    public void store(View v){
        //create shared preferences object
        SharedPreferences.Editor spEdit = getSharedPreferences(SP_FileName,MODE_PRIVATE).edit();

        numToStore = Integer.parseInt(editText.getText().toString());

        //statement below is going to pass numbers from editText to shred preferences file
        spEdit.putInt("number", numToStore);
        spEdit.commit();
        Toast.makeText(getApplicationContext(),"Successfully Save !",Toast.LENGTH_SHORT).show();
    }

    //create a method to retrieve
    public void retrieve(View v){
        SharedPreferences sp = getSharedPreferences(SP_FileName,MODE_PRIVATE);

        //this statement is for you to access shared preferences file
        numToDisplay = sp.getInt("number", 0);

        //display in textView
        textView.setText(String.valueOf(numToDisplay));
    }
}