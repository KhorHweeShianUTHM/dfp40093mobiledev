package com.example.labact12_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button save, retrieve, update, delete;
    EditText name, password;
    TextView display;
    //object for sqLiteDatabase create
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //input btn and variable
        save = (Button) findViewById(R.id.savebtn);
        retrieve = (Button) findViewById(R.id.retrievebtn);
        update = (Button) findViewById(R.id.updatebtn);
        delete = (Button) findViewById(R.id.deletebtn);

        //input edit text and variable
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.pass);
        display = (TextView) findViewById(R.id.display);

        //call variable to run
        save.setOnClickListener(this);
        retrieve.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        //send data from variable to db
        MyHelper object = new MyHelper(this, "dbname", null, 1);
        db = object.getWritableDatabase();
    }

    //using switch case to run the function
    @Override
    public void onClick(View v) {
        //declare variable to use at the case switch
        String names=name.getText().toString();
        String pass=password.getText().toString();
        switch (v.getId()) {
            case R.id.savebtn:
                //declare string for insert data
                String query1="insert into user values('"+names+"','"+pass+"')";
                db.execSQL(query1);
                //variable btn call for inserted
                display.setText("Record Inserted");
                name.setText("");
                password.setText("");
                break;

            case R.id.retrievebtn: //for getting record
                //declare string object for retrieve
                String query2="select * from user where name='"+names+"'";
                //declare cursor object for condition in case
                Cursor cursor;
                cursor=db.rawQuery(query2,null);
                //cursor condition for object in case
                if (cursor.moveToNext()) {
                    //declare string for retrieved
                    String ppp=cursor.getString(cursor.getColumnIndexOrThrow("password"));
                    display.setText("Password is : "+ppp);
                } else{
                    display.setText("No Record is Found");
                }
                break;

            case R.id.updatebtn:
                //variable case use to insert the data at db
                String query3= "update user set password='"+pass+"' where name='"+names+"'";
                db.execSQL(query3);
                //variable btn call for updated
                display.setText("Record Updated");
                name.setText("");
                password.setText("");
                break;

            case R.id.deletebtn:
                //declare string for insert data
                String query4="delete from user where name='"+names+"'";
                db.execSQL(query4);
                //variable btn call for deleted
                name.setText("");
                password.setText("");
                display.setText("Record deleted");
                break;
        }
    }
}