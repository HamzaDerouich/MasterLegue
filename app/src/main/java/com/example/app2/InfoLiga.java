package com.example.app2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InfoLiga extends AppCompatActivity {

    ImageView imageView;
    Button button ;
    TextView nombre, descripcion, año, pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_liga);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Liga liga = (Liga) getIntent().getSerializableExtra("liga");

        // Initialize views
        nombre = findViewById(R.id.NombreLiga);
        imageView = findViewById(R.id.imagenLiga);
        descripcion = findViewById(R.id.descripcionLiga);
        pais = findViewById(R.id.paisLiga);
        año = findViewById(R.id.añoFundada);
        button = findViewById(R.id.button);


            nombre.setText(liga.getNombre());
            imageView.setImageResource(liga.getImagen());
            descripcion.setText(liga.getDescripcion());
            pais.setText(liga.getPais());
            año.setText(String.valueOf(liga.getAño_fundada()));

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

    }
}
