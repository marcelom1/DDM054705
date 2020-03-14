package com.example.inter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   // ListView listView;
    ListView listComponentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listComponentes = findViewById(R.id.list_view);

        final ArrayList<String> lista_componentes = new ArrayList<>();
        lista_componentes.add("Botão");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, lista_componentes);

        listComponentes.setAdapter(adapter);

        listComponentes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, lista_componentes.get(position), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, ComponenteView.class);

                intent.putExtra("Componente", lista_componentes.get(position));
                startActivity(intent);

            }
        });

        //listView = findViewById(R.id.list_view);

        //final ArrayList<String> lista_frutas = new ArrayList<>();

        //lista_frutas.add("maça");
        // lista_frutas.add("uva");
        // lista_frutas.add("morango");
        // lista_frutas.add("pera");
        // lista_frutas.add("pessego");

        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,lista_frutas);

        //listView.setAdapter(adapter);

        //listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //    @Override
        //    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //        Toast.makeText(MainActivity.this,lista_frutas.get(position),Toast.LENGTH_LONG).show();
//
        //              Intent intent = new Intent(MainActivity.this,ComponenteView.class);
//
        //              intent.putExtra("fruta",lista_frutas.get(position));
//
        //              startActivity(intent);
    }
    //       });
}

