package com.example.notasandroid2.models;

public class NotaModel {
    private int _id;
    private String nombre;
    private String titulo;
    private String contenido;

    public NotaModel() {
    }

    public NotaModel(String nombre, String titulo, String contenido) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public NotaModel(int _id, String nombre, String titulo, String contenido) {
        this._id = _id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "notaModel{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
