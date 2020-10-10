package com.example.notas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notas.controller.ControllerNotas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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
        if ((posicao == -1) && (!(editText.getText().toString().isEmpty()))) {
            controller.salvarNota(editText.getText().toString());
        }else if(!(editText.getText().toString().isEmpty())){
            controller.atualizarNota(posicao,editText.getText().toString());
        }
    }

    private View.OnClickListener excluirNota = new View.OnClickListener() {
        public void onClick(View v) {
            if (posicao > -1) {
                controller.excluirNota(posicao);
                finish();
            }
        }
    };




}
