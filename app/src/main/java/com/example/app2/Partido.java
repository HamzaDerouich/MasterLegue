package com.example.app2;

import java.io.Serializable;

public class Partido implements Serializable {

    private String resultado;
    private int imagen;
    private String descripcion;
    private String goleadores;

    // Constructor con parámetros
    public Partido(String resultado, int imagen, String descripcion, String goleadores) {
        this.resultado = resultado;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.goleadores = goleadores;
    }

    // Getters y setters
    public String getResultado() {
        return resultado;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public String getGoleadores() {
        return goleadores;
    }



    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
