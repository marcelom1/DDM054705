package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase meudb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
