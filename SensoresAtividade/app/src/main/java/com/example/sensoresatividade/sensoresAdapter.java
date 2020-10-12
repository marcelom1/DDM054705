package com.example.sensoresatividade;

import android.content.Context;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class sensoresAdapter extends RecyclerView.Adapter<sensoresAdapter.MyViewHolder>{
    Context mContext;
    int mResource;
    List<SensorCel> mSensor;

    public sensoresAdapter(Context c, int template, List<SensorCel> sensor) {
        this.mContext = c;
        this.mResource = template;
        this.mSensor = sensor;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View convertView = layoutInflater.inflate(mResource,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(convertView);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        SensorCel s = mSensor.get(position);

        holder.nome.setText(s.getNome());
        holder.valor.setText(s.getValor()+"");

    }

    @Override
    public int getItemCount() {
        return mSensor.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome;
        TextView valor;

        public MyViewHolder(@NonNull View convertView) {
            super(convertView);

            nome = convertView.findViewById(R.id.tvNome);
            valor = convertView.findViewById(R.id.tvValor);

        }
    }
}
