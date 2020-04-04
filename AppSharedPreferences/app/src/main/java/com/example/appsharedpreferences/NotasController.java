package com.example.appsharedpreferences;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class NotasController {
    SharedPreferences sharedPreferences;
    public NotasController(Context c) {
        this.sharedPreferences = c.getSharedPreferences("notepad", c.MODE_PRIVATE);
    }


    public void Salvar (String key, String str){


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Nome","Daniel");
        editor.commit();

    }
    public  String getString (String key){
        return sharedPreferences.getString(key, "");
    }
}
