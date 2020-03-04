package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edPeso, edAltura;
    TextView tvIMC;
    ImageView img;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edPeso = findViewById(R.id.editTextPeso);
        edAltura = findViewById(R.id.editTextAltura);
        tvIMC = findViewById(R.id.textViewIMC);
        img = findViewById(R.id.imageViewIMC);
        seekBar = findViewById(R.id.seekBarrra);
        img.setImageResource(R.drawable.perfil);

    }

    public double calculaIMC(double peso, double altura){
        if (altura == 0 || peso == 0)
            return 0;
        return peso/(altura*altura);
    }

    public void imc (View view){
        double peso = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());
        double imc = calculaIMC(peso,altura);
        trocarImagem(imc);
        String resultado = String.format("%.2f", imc);
        //seekBar.setProgress((int) imc);
        tvIMC.setText(resultado);
    }

    public  void trocarImagem (double imc){
        if (imc <= 18.5){
            img.setImageResource(R.drawable.abaixopeso);
        }else if(imc <= 24.9){
            img.setImageResource(R.drawable.normal);
        }else if(imc <= 29.9){
            img.setImageResource(R.drawable.sobrepeso);
        }else if(imc <= 34.9){
            img.setImageResource(R.drawable.obesidade1);
        }else if(imc <= 39.9){
            img.setImageResource(R.drawable.obesidade2);
        }else if(imc >= 40){
            img.setImageResource(R.drawable.obesidade3);
        }

    }
}
