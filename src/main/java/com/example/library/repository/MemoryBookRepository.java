package com.example.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
//Este repositorio ya va poder agregarnos libros, obtener un libro, tener todos los libros, borrar un libro, traer todos los libros 

//creo esta clase para implementar implements  en rojo click derecho implemente todos los metodos
public class MemoryBookRepository implements BookRepository {

      private Map<String, Book> booksMap; //Ir guardando los libros y accesarlos facilmente me lo permite el Map (Hash)

        public MemoryBookRepository() {
          booksMap= new HashMap<>();
    }
    ///

    @Override
    public List<Book> getAll() {
        List<Book>books=new ArrayList<>();
        books.addAll(booksMap.values());
        return books;
        // Obtener todos los libros que esta dentro de ese mapa
        
    }

    @Override
    public Book get(String bookId) {
        return booksMap.get(bookId);
    }

    @Override
    public List<Book> findByAuthor(String autor) {
       
        return booksMap.values().stream().filter(
            book -> book.getAutor().toLowerCase().indexOf(autor.toLowerCase()) >= 0)
            .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitulo(String titulo) {
        return booksMap.values().stream().filter(
            book -> book.getTitulo().toLowerCase().indexOf(titulo.toLowerCase()) >= 0)
            .collect(Collectors.toList());
    }

    @Override
    public Book save(Book book) {
        if (book.getBookId()== null)
        {
            book.setBookId(String.valueOf(System.currentTimeMillis()));
            //El objeto lo convierte en un string , generar una clave sintetica id unica generado por el sistema (currentTimeMillis)  
        }
        booksMap.put(book.getBookId(), book);  //Actualizar el valor en el mapa, ponga en el mapa en el bookid coloque el libro
       
        return book;
    }

    @Override
    public Book delete(String bookId) {
        return booksMap.remove(bookId);
    }

}
