package com.example.notas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ActivityEditNotas extends AppCompatActivity {
    EditText editText;
    ControllerNotas controller;
    int posicao;
    Button btnExcluir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        posicao = getIntent().getExtras().getInt("position");

        this.editText = findViewById(R.id.editTextNota);

        controller = new ControllerNotas(getApplicationContext());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Salvando...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                salvarAtualizarNota();
            }
        });
        Log.d("Tabela_Pessoas", "OnCre Ac");
        btnExcluir = findViewById(R.id.btnExcluir);
        if (posicao == 0){
            btnExcluir.setVisibility((View.INVISIBLE));
        }else{
            btnExcluir.setOnClickListener(excluirNota);
        }


    }

   @Override
   protected void onStart() {
        super.onStart();
       if (posicao > -1) {
           String text = controller.recuperaNota(posicao).getText();
           editText.setText(text);
       }else{
           editText.setText("");
       }

    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    private void salvarAtualizarNota(){
        Log.d("Tabela_Pessoas", "OnCre Ac");
        if (posicao == -1) {
            Log.d("Tabela_Pessoas", posicao+"salvando");
            controller.salvarNota(editText.getText().toString());
        }else if(!(editText.getText().toString().isEmpty())){
            Log.d("Tabela_Pessoas", posicao+"aaaaaaa");
            controller.atualizarNota(posicao,editText.getText().toString());
        }
        Log.d("Tabela_Pessoas", "depois");
    }

    private View.OnClickListener excluirNota = new View.OnClickListener() {
        public void onClick(View v) {
            Log.d("Tabela_Pessoas", "Oonck");
            if (posicao != 0) {
                controller.excluirNota(posicao);
                finish();
            }
        }
    };




}
