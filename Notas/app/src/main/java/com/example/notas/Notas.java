package com.example.notas;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Notas {
    SharedPreferences preferencias;
    SharedPreferences.Editor editorPreferencias;
    Context context;
    private static final String PREFERENCIAS_FILE = "nota";

    public Notas(Context c) {
        this.context = c;
        preferencias = this.context.getSharedPreferences(PREFERENCIAS_FILE, Context.MODE_PRIVATE);
        editorPreferencias = preferencias.edit();
    }

    public void salvaNota(String s) {
        editorPreferencias.putString("nota", s);
        editorPreferencias.commit();
    }

    public String recuperaNota() {
        if (this.preferencias.contains("nota")) {
            String s = context.getResources().getString(R.string.nota_recuperada);
            Toast.makeText(context, s, Toast.LENGTH_LONG).show();
            return this.preferencias.getString("nota", "");
        } else {
            return "";
        }

    }
}
