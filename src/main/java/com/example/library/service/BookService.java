package com.example.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;


@Service
public class BookService {

    private final BookRepository bookRepository; //creamos variable de tipo BookRepository
    
    //creamos el constructor click derecho, para spring cuando va crear la clase se da cuenta que necesita el constructor
    //y se encarga de promovernos el BookRepository que esta dado de alta en spring.Constructor recibe el Bookrepository
    public BookService(BookRepository bookRepository) {  
        this.bookRepository = bookRepository;
    }
    //

    //Exponer los metodos que vamos a utilizar en la capa del controlador, que es el que va a
    //recibir todas las peticiones que vienen de afuera.
    public List<Book> getAll(){
       return bookRepository.getAll();        
    }

    public Book get(String bookId){
       return bookRepository.get(bookId);
    }

    public List<Book> findByAuthor(String authorId){
       return bookRepository.findByAuthor(authorId);
    }

    public List<Book> findByTitulo(String titulo){
        return bookRepository.findByTitulo(titulo); //desde el servicio accedo al Repositorio datos
     }

    public Book addBook(Book book){
      book.setBookId(null); //le ponemos el bookId=null para cuando ingrese al repository lo cree automaticamene
      return bookRepository.save(book);

    }

    public Book updateBook(String bookId,Book book){
        Book bookR= bookRepository.get(book.getBookId());
        if (bookR==null){
        return null;
        }
        book.setBookId(bookId);
        return bookRepository.save(book);
    }
    
    public Book deleteBook(String bookId){
        return bookRepository.delete(bookId);
    }
}
