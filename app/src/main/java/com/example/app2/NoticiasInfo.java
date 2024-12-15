package com.example.app2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class NoticiasInfo extends Fragment {

    private ListView listView;
    private static ArrayList<Noticia> listadoNoticias = new ArrayList<>();
    private AdapatadorNoticia adapatadorNoticia;

    // Tu clave API de NewsAPI
// Tu clave API de NewsAPI (sin la URL completa)
    private static final String API_KEY = "5387a7c5e8ce41aebe06a8fb4b6f4f50";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_noticias, container, false);

        listView = rootView.findViewById(R.id.listViwLigas);
        adapatadorNoticia = new AdapatadorNoticia(getContext(), listadoNoticias);
        listView.setAdapter(adapatadorNoticia);

        getNews();


        // Configuración del listener para los items de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Noticia noticiaSeleccionada = listadoNoticias.get(i);
                Toast.makeText(getContext(), "Seleccionaste: " + noticiaSeleccionada.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
    void getNews() {
        ApiUtilities.getApiClient().getCategory("us", "sports" ,100, API_KEY).enqueue(new Callback<NoticiaResponse>() {
            @Override
            public void onResponse(Call<NoticiaResponse> call, Response<NoticiaResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Noticia> noticias = response.body().getListado_noticias();
                    if (noticias != null && !noticias.isEmpty()) {
                        listadoNoticias.clear();
                        listadoNoticias.addAll(noticias);
                        adapatadorNoticia.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getContext(), "No se recibieron noticias deportivas", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Error al obtener noticias", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NoticiaResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}




