package com.example.notas.controller;

import android.content.Context;

import com.example.notas.models.Nota;
import com.example.notas.models.NotasDao;

import java.util.ArrayList;

public class ControllerNotas {
    Context context;
    NotasDao dao;

    public ControllerNotas(Context c) {
        this.context = c;
        this.dao = new NotasDao(c);
    }

    public void salvarNota(String text){
        Nota nota = new Nota(text);
        dao.insertNotas(nota);
    }

    public Nota recuperaNota(int id){

        return dao.getNota(id);

    }

    public ArrayList<Nota> recuperarTodasNotas(){
        ArrayList<Nota> lista;
        lista = dao.getAll();

        return lista;
    }

    public void atualizarNota(int id, String text){
        Nota nota = new Nota(id,text);
        dao.atualizaNotas(nota);

    }

    public void excluirNota(int id){
        dao.dropNota(id);
    }
}
