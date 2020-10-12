package com.example.sensoresatividade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager mSensorManeger;
    Sensor mSensorGeneric;
    TextView mTvLight;
    RecyclerView recyclerView;
    List<SensorCel> listSensores;
    sensoresAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mSensorManeger = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
        //mSensorLight = mSensorManeger.getDefaultSensor(Sensor.TYPE_LIGHT);
        //mSensorManeger.registerListener(this,mSensorLight,SensorManager.SENSOR_DELAY_NORMAL);

        List<Sensor> listSensor = mSensorManeger.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorListText = new StringBuilder();


        //for (Sensor s: listSensor){
        //    sensorListText.append(s.getName()).append(System.getProperty("line.separator"));
        //}
        //mTvLight.setText(sensorListText);
        if (listSensores == null){
            retornarSensores();
        }

        adapter = new sensoresAdapter(
                getApplicationContext(),
                R.layout.list_item,
                listSensores
        );

        recyclerView.setAdapter(adapter);

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    private void retornarSensores(){
        List<Sensor> listSensor = mSensorManeger.getSensorList(Sensor.TYPE_ALL);
        listSensores = new ArrayList();
        for (Sensor s: listSensor){
            mSensorGeneric = mSensorManeger.getDefaultSensor(s.getType());
            mSensorManeger.registerListener(this,mSensorGeneric,SensorManager.SENSOR_DELAY_NORMAL);
            SensorCel sen = new SensorCel(s.getName(),0);
            listSensores.add(sen);
        }

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensortype = sensorEvent.sensor.getType();
        float currentValue = sensorEvent.values[0];

        for (SensorCel s: listSensores){
            if (s.Nome == sensorEvent.sensor.getName()){
                s.Valor = currentValue;
                adapter.notifyDataSetChanged();
                break;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
