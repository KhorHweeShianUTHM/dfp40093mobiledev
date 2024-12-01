package com.example.labact15firebase2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnInsertData;
    Button btnRetreiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertData = findViewById(R.id.btnInsertData);
        btnRetreiveData = findViewById(R.id.btnRetreiveData);
        btnInsertData.setOnClickListener(this);
        btnRetreiveData.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnInsertData:
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
                break;
            case R.id.btnRetreiveData:
                startActivity(new Intent(MainActivity.this,MainActivity3.class));
                break;
        }
    }
}
