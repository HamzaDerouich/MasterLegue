package com.example.app2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdapatadorNoticia extends BaseAdapter {

    private List<Noticia> lista;
    private Context context;

    public AdapatadorNoticia(Context c, List<Noticia> noticias) {
        this.context = c;
        this.lista = noticias != null ? noticias : new ArrayList<>();
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View list = inflater.inflate(R.layout.fila_notica, viewGroup, false);

        TextView nombre = list.findViewById(R.id.textViewTitle);
        ImageView imagen = list.findViewById(R.id.imageViewLogo);

        Noticia noticia = lista.get(i);

        nombre.setText(noticia.getTitle());

        String imageUrl = noticia.getUrlToImage();
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(context)
                    .load(imageUrl);
        } else {
            // Si no hay imagen, puedes poner una imagen predeterminada
            Glide.with(context)
                    .load(R.drawable.logo) // Imagen predeterminada
                    .into(imagen);
        }
        return list;
    }

}
