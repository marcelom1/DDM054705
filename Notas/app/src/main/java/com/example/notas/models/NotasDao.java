package com.example.notas.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notas.models.Nota;

import java.util.ArrayList;

public class NotasDao {
    Context mContext;
    SQLiteDatabase meudb;

    public NotasDao(Context mContext) {
        this.mContext = mContext;

        meudb = mContext.openOrCreateDatabase("bdNotas", mContext.MODE_PRIVATE, null);

        meudb.execSQL("CREATE TABLE IF NOT EXISTS notas(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "text vachar);");
    }

    public void insertNotas(Nota notas){
        ContentValues notasValores = new ContentValues();
        notasValores.put("text", notas.getText());
        meudb.insert("notas", null, notasValores);
    }

    public void atualizaNotas(Nota notas){
        ContentValues notasValores = new ContentValues();
        notasValores.put("text", notas.getText());
        meudb.update("notas", notasValores,"_id="+ notas.getId(),null);
    }

    public ArrayList<Nota> getAll(){
        Cursor dataset = meudb.rawQuery("SELECT * FROM notas ", null);

        dataset.moveToFirst();
        ArrayList<Nota> ListaNotas = new ArrayList<>();
        while (!dataset.isAfterLast()){
            int id = dataset.getInt(dataset.getColumnIndex("_id"));
            String text = dataset.getString(dataset.getColumnIndex("text"));

            ListaNotas.add(new Nota(id,text));

            dataset.moveToNext();
        }
        return  ListaNotas;
    }

    public Nota getNota(int id){

        String[] whereArgs = { String.valueOf(id) };
        Cursor dataset = meudb.rawQuery("SELECT * FROM notas WHERE _id = ?", whereArgs);
        dataset.moveToFirst();

        String text = dataset.getString(dataset.getColumnIndex("text"));

        Nota retorno = new Nota(id, text);

        return  retorno;
    }

    public  void dropNota(int id){
        meudb.delete("notas","_id="+id,null);
    }

}
