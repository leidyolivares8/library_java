package com.example.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Book {

    private String bookId;
    private String titulo;
    private String descripcion;
    private String autor;
    private double precio;
    private int cantidad;

    public Book(String bookId, String titulo, String descripcion, String autor, double precio, int cantidad) {
        this.bookId = bookId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
}
