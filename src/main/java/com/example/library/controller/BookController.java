package com.example.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping({"book"}) //Path /book para entrar aqui yo decido a cual recurso acceder
public class BookController {

    //El controlador solo tiene que saber la capa de servicios, no el repositorio

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("") //método cuando le pida todos los libros un mapping a Get
    public List<Book> getAll(@RequestParam(required=false) String autorId, String titulo) //regresar una lista de libros
    {
        System. out. println("autorId:"+ autorId+ " titulo:"+ titulo);
        if (autorId != null){ 
            return this.bookService.findByAuthor(autorId);
         }        
        else if  (titulo != null) {
            return this.bookService.findByTitulo(titulo);
        }
        else{
            return this.bookService.getAll();
        }
    }

    @GetMapping("/{bookId}")
     public Book get(@PathVariable String bookId){
        return bookService.get(bookId);
     }


    @PostMapping("")
    public Book addBook(@RequestBody Book book)
    {
      return this.bookService.addBook(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable String bookId,@RequestBody Book book){
        Book ret=this.bookService.updateBook(bookId, book);
        return ret;
    }

    @DeleteMapping("/{bookId}")
    public Book deleteBook(@PathVariable String bookId)
    {
    return this.bookService.deleteBook(bookId);
    }


        
}
