package com.example.library.repository;

import java.util.List;

import com.example.library.model.Book;

public interface BookRepository {  //cuando se define el repositorio realmente  no una clase sino interfaz

    public List<Book> getAll(); //metodo para regresar lista de todos los libros model Book
    public Book get(String bookId); //metodo regresar un libro
    public List<Book> findByAuthor(String autor); // metodo debe regresar lista de los libros de un autor.
    public List<Book> findByTitulo(String titulo);//metodo para regresar libros por el titulo
    public Book save (Book book);//metodo para guardar un libro
    public Book delete(String bookId); //metodo para borrar un libro 
   
}
