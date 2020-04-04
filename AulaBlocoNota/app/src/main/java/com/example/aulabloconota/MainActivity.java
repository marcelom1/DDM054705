package com.example.aulabloconota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotasControler notas = new NotasControler(this);

        notas.salvar("Nome1", "Marcelo");
        notas.salvar("Nome2", "Miglioli");

        Log.d("nome:", notas.getString("nome1"));
        Log.d("nome:", notas.getString("nome2"));
    }
}
