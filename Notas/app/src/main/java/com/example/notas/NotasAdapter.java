package com.example.notas;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notas.models.Nota;

import java.util.ArrayList;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.MyViewHolder> {

    Context mContext;
    int mResource;
    ArrayList<Nota> mNota;

    public NotasAdapter(Context c, int template, ArrayList<Nota> notas) {
            this.mContext = c;
            this.mResource = template;
            this.mNota = notas;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

            final Nota nota = mNota.get(position);
            holder.editText.setText(nota.getText());
            holder.editText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext,ActivityEditNotas.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("position",nota.getId());
                    mContext.startActivity(i);
                }
            });



    }

    @Override
    public int getItemCount() {
            return mNota.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView editText;

        public MyViewHolder(@NonNull View convertView) {
            super(convertView);

            editText = convertView.findViewById(R.id.editText);



        }
    }
}