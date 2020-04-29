package com.example.notas;

import android.content.Context;
import android.util.Log;

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
}
