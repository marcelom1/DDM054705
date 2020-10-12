package com.example.sensoresatividade;

public class SensorCel {
     String Nome;
     float Valor;

     public SensorCel(String nome, float valor){
        this.Nome = nome;
        this.Valor = valor;
     }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float valor) {
        Valor = valor;
    }
}
