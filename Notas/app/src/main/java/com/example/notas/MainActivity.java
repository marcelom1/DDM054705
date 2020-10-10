package com.example.notas;

import android.content.Intent;
import android.os.Bundle;

import com.example.notas.controller.ControllerNotas;
import com.example.notas.models.Notas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Notas nota;
    EditText editText;
    ControllerNotas controller;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ActivityEditNotas.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("position",-1);
                getApplicationContext().startActivity(i);
            }
        });






    }
    @Override
    protected void onResume() {
        super.onResume();
        ControllerNotas notasController = new ControllerNotas(getApplicationContext());
        NotasAdapter adapter = new NotasAdapter(
                getApplicationContext(),
                R.layout.list_item_notas,
                notasController.recuperarTodasNotas()
        );

        recyclerView.setAdapter(adapter);
    }


}
