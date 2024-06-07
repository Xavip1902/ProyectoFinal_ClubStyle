package com.example.proyectofinal_clubstyle.dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemDominio implements Serializable {
    private String titulo;
    private String descripcion;
    private ArrayList<String> picUrl;
    private double precio;
    private double oldPrice;
    private int review;
    private double rating;
    private int NumeroEnCarrito;

    public ItemDominio(String titulo, String descripcion, ArrayList<String> picurl, double precio, double oldPrice, int review, double rating) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.picUrl = picurl;
        this.precio = precio;
        this.oldPrice = oldPrice;
        this.review = review;
        this.rating = rating;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<String> getPicUrl() {
        return picUrl;
    }

    public void setPicurl(ArrayList<String> picUrl) {
        this.picUrl = picUrl;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumeroEnCarrito() {
        return NumeroEnCarrito;
    }

    public void setNumeroEnCarrito(int numeroEnCarrito) {
        NumeroEnCarrito = numeroEnCarrito;
    }
}
