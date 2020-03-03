package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edPeso, edAltura;
    TextView tvIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edPeso = findViewById(R.id.editTextPeso);
        edAltura = findViewById(R.id.editTextAltura);
        tvIMC = findViewById(R.id.textViewIMC);
    }

    public double calculaIMC(double peso, double altura){
        if (altura == 0 || peso == 0)
            return 0;
        return peso/(altura*altura);
    }

    public void imc (View view){
        double peso = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());
        String resultado = String.format("%.2f", calculaIMC(peso,altura));
        tvIMC.setText(resultado);
    }
}
