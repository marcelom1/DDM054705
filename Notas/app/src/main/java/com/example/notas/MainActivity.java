package com.example.notas;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Notas nota;
    EditText editText;
    ControllerNotas controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText = findViewById(R.id.editText);

        //nota = new Notas(getApplicationContext());
        controller = new ControllerNotas(getApplicationContext());
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                nota.salvaNota(editText.getText().toString());
            }
        });*/
        controller.salvarNota(editText.getText().toString());


    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<Nota> listaNotas = controller.recuperarTodasNotas();
        String text = controller.recuperarTodasNotas().get(10).getText();
        editText.setText(text);

    }
    @Override
    protected void onPause() {
        super.onPause();
        nota.salvaNota(editText.getText().toString());
    }




}
