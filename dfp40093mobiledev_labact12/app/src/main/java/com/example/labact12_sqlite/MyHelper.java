package com.example.labact12_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {
    //right click mouse and select generate to create constructor
    public MyHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //location create table db
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //table create in db function
        String sql="create table user(name varchar,password varchar)";
        sqLiteDatabase.execSQL(sql);//database connect
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {
        //update table in db function
        sqLiteDatabase.execSQL("DROP table if exists user");
        onCreate(sqLiteDatabase);
    }
}