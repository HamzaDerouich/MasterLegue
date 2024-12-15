package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Ligas extends Fragment {

    ListView listView;
    static ArrayList<Liga> listado_liga = new ArrayList<Liga>() ;

    public Ligas() {
        // Constructor vacío
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ligas, container, false);

        String[] nombres = getResources().getStringArray(R.array.nombres);
        int[] imagenes = {R.drawable.premier_league, R.drawable.laliga, R.drawable.serie, R.drawable.bundesliga, R.drawable.major,R.drawable.primeira};
        String[] descripcion = getResources().getStringArray(R.array.descripciones);
        String[] año_fundacion = getResources().getStringArray(R.array.años_fundacion);
        String[] pais = getResources().getStringArray(R.array.paises_origen);


        listView = rootView.findViewById(R.id.listViwLigas);
        Adapatador adapter = new Adapatador(getContext());
        listView.setAdapter(adapter);

        for (int i = 0; i < 6; i++)
        {
            listado_liga.add(new Liga(nombres[i],imagenes[i],descripcion[i],año_fundacion[i],pais[i]));

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                String nombre = nombres[i];
                Liga liga = null ;
                for ( Liga liga1 : listado_liga)
                {
                    if( liga1.getNombre().equals(nombre) )
                    {
                        liga = liga1;
                    }
                }
                Intent intent = new Intent(getContext(),InfoLiga.class);
                intent.putExtra("liga", liga);
                startActivity(intent);

            }
        });

        return rootView;
    }

}
