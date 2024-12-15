package com.example.app2;

import java.io.Serializable;

public class Liga implements Serializable {
    String nombre;
    int imagen ;
    String descripcion;
    String pais ;
    String año_fundada;

    public Liga()
    {

    }

    public Liga( String nombre , int imagen , String descripcion , String pais , String año_fundada)
    {
        this.año_fundada = año_fundada;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getAño_fundada() {
        return año_fundada;
    }

    public int getImagen() {
        return imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
