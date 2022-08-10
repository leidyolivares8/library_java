package com.example.library.util;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@Component //Arranque como spring no es un servicio porque no le da servicio nadie,
// no es controlador porque la gente no llegue hasta aqui a hacer peticiones, ni repositorio , 
//es una clase utileria.
public class DummyBookFilter {

    private final BookService bookService;

    public DummyBookFilter(BookService bookService) {
        this.bookService = bookService;
    }

    @PostConstruct    //metodo se va a ejecutar una vez se cree el objeto lo busca spring
    public void init()
    {
      bookService.addBook(new Book(null,"El señor de los anillos","Mitología","John Ronald Reuel Tolkien",100000,45));
      try {Thread.sleep(100);} catch (InterruptedException e) {}
      bookService.addBook(new Book(null,"Harry Potter","Novela fantástica","J. K. Rowling",110000,20));
      try {Thread.sleep(100);} catch (InterruptedException e) {}
      bookService.addBook(new Book(null,"El poder del Ahora","Estar en momento presente","Eckhart Tolle",200000,50));
      try {Thread.sleep(100);} catch (InterruptedException e) {}
      bookService.addBook(new Book(null,"La estrategia del océano azul","Crear espacios de mercado","Chan Kim y Renée Mauborgne",80000,10));
  
    }
    
}
