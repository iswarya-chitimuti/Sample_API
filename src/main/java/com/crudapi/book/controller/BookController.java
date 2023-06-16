package com.crudapi.book.controller;

import com.crudapi.book.model.Book;
import com.crudapi.book.repository.BookRepository;
import com.crudapi.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/details")

public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public List<Book> getDetails()
    {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    @GetMapping("/book/service")
    public List<Book> getDetailsByService()
    {
        List<Book> bookList = bookService.getAll();
        return bookList;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> getDetailsById(@PathVariable(value = "id") Long id)
    {
        Optional<Book> bookId = bookService.getById(id);
        return ResponseEntity.ok().body(bookId);
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book)
    {

        return bookRepository.save(book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> newBook(@PathVariable(value = "id") Long id, @RequestBody Book book)
    {
        Optional<Book> book1 = bookRepository.findById(id);
        book1.get().setTitle(book.getTitle());
        book1.get().setGenre(book.getGenre());
        book1.get().setAuthor(book.getAuthor());
        final Book book2 = bookRepository.save(book);
        return ResponseEntity.ok().body(book2);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "id") Long id)
    {
        Optional<Book> book = bookRepository.findById(id);
        bookRepository.delete(book.get());
        return new ResponseEntity<>("Book details with id:" + id + "has been deleted", HttpStatus.OK);
    }


    @GetMapping("/book/byTitle")
    public ResponseEntity<List<Book>> getBookByTitle(@RequestParam(name = "title") String title)
    {
        List<Book> bookList = bookService.getByTitle(title);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/book/byGenre")
    public ResponseEntity<List<Book>> getBookByGenre(@RequestParam(name = "genre") String genre)
    {
        List<Book> bookList = bookService.getByGenre(genre);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/book/byAuthor")
    public ResponseEntity<List<Book>> getBookByAuthor(@RequestParam(name = "author") String author)
    {
        List<Book> bookList = bookService.getByAuthor(author);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}