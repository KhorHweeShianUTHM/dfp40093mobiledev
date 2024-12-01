package com.example.heartattacksymptoms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button info, symptoms, causes, prevent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        info = (Button) findViewById(R.id.Button1);
        symptoms = (Button) findViewById(R.id.Button2);
        causes = (Button) findViewById(R.id.Button3);
        prevent = (Button)findViewById(R.id.Button4);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentThirdActivity();
            }
        });

        symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentFourthActivity();
            }
        });

        causes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentFifthActivity();
            }
        });

        prevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentSixthActivity();
            }
        });
    }

    public void intentThirdActivity(){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void intentFourthActivity(){
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

    public void intentFifthActivity(){
        Intent intent = new Intent(this, FifthActivity.class);
        startActivity(intent);
    }

    public void intentSixthActivity(){
        Intent intent = new Intent(this, SixthActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu;this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.exit_action:
                onBackPressed();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.drawable.heart_attack_icon);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                        homeIntent.addCategory(Intent.CATEGORY_HOME);
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(homeIntent);
                        System.exit(1);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}