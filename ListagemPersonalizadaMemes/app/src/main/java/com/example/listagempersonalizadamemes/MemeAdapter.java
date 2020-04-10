package com.example.listagempersonalizadamemes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

class MemeAdapter extends ArrayAdapter {
    Context mContext;
    int mResource;

    public MemeAdapter(Context context, int resource,List objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent,false);

        Meme meme = (Meme)getItem(position);

        TextView tvNome = convertView.findViewById(R.id.tvNome);
        ImageView imagemView = convertView.findViewById(R.id.imageView);


        tvNome.setText(meme.getNome());
        imagemView.setImageResource(meme.getImagem());

        return convertView;
    }
}
