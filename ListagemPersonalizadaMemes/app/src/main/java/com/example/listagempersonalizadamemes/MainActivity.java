package com.example.listagempersonalizadamemes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Memes memes = new Memes();
        ArrayList<Meme> listaMemes = new ArrayList<>();
        for(Meme m: memes.MEMES){
            listaMemes.add(m);
        }

        //Associação list View
        listView = findViewById(R.id.listView);

        MemeAdapter adapter = new MemeAdapter(
                getApplicationContext(),
                R.layout.list_item_meme,
                listaMemes
        );

        listView.setAdapter(adapter);

    }
}
