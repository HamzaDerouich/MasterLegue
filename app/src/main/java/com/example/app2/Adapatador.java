package com.example.app2;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapatador extends BaseAdapter {

    ArrayList<Liga> lista;
    Context context;

    Adapatador( Context c )
    {
        context = c;
        lista = new ArrayList<Liga>();

        Resources resources = c.getResources();
        String[] nombres_array = resources.getStringArray(R.array.nombres);
        int[] imagenes_array = {R.drawable.premier_league,R.drawable.laliga,R.drawable.serie,R.drawable.bundesliga,R.drawable.ligueone,R.drawable.major,R.drawable.primeira}  ;
        String[] descripcon_array = resources.getStringArray(R.array.descripciones);
        String[] años_fundacion_array = resources.getStringArray(R.array.años_fundacion);
        String[] pais_origen_array = resources.getStringArray(R.array.paises_origen);

        for (int i = 0; i < 7; i++)
        {
            lista.add(new Liga(nombres_array[i],imagenes_array[i],descripcon_array[i],años_fundacion_array[i],pais_origen_array[i]));
        }


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
        View list = inflater.inflate(R.layout.filas_lista,viewGroup,false);
        TextView nombre = (TextView) list.findViewById(R.id.textViewTitle);
        ImageView imagen = (ImageView) list.findViewById(R.id.imageViewLogo);

        Liga liga = lista.get(i);

        nombre.setText(liga.getNombre());
        imagen.setImageResource(liga.getImagen());

        return list;
    }
}
