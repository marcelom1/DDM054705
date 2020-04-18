package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // configurando recycle view
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FrutaController frutaController = new FrutaController();
        FrutaAdapter adapter = new FrutaAdapter(
                getApplicationContext(),
                R.layout.template_item_fruta,
                frutaController.FRUTAS

        );


        recyclerView.setAdapter(adapter);

        /*recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
            getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.On
                )*/
    }
}
