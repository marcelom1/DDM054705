package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class PessoaDao {
    Context mContext;
    SQLiteDatabase meudb;

    public PessoaDao (Context c) {
        mContext = c;
        meudb = mContext.openOrCreateDatabase("bd", mContext.MODE_PRIVATE, null);

        meudb.execSQL("CREATE TABLE IF NOT EXISTS pessoas(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "nome vachar);");
    }

    public void insertPessoa (Pessoa pessoa){

        ContentValues pessoaValores = new ContentValues();
        pessoaValores.put("nome",pessoa.getNome());
        meudb.insert("pessoas", null, pessoaValores);
    }

    public ArrayList<Pessoa> getAll(){

        Cursor dataset = meudb.rawQuery("SELECT * FROM PESSOAS ", null);

        dataset.moveToFirst();
        ArrayList<Pessoa> ListaPessoa = new ArrayList<>();
        while (!dataset.isAfterLast()){
            ListaPessoa.add(new Pessoa(dataset.getInt(dataset.getColumnIndex("id")),dataset.getString(dataset.getColumnIndex("nome"))));

          //  Log.d("Tabela_Pessoas",dataset.getString(dataset.getColumnIndex("nome")));
            dataset.moveToNext();
        }

        return  ListaPessoa;


    }
}
