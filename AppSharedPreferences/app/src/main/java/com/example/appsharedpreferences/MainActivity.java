package com.example.appsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    NotasController notas;
    private TextView textResultado;
    private EditText editText;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final NotasController notas = new NotasController(this);

        button = findViewById(R.id.buttonSalvar);
        editText=findViewById(R.id.editText);
        textResultado=findViewById(R.id.textResultado);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notas.Salvar("nota",editText.getText().toString());
                textResultado.setText(notas.getString("nota"));

            }
        });



    }

    public void SalvarNota(View v){
        notas.Salvar("nota", editText.getText().toString());

    }
    @Override
    protected void onResume(){
        super.onResume();
        textResultado.setText(notas.getString("nota"));
    }
}
