package com.crudapi.book.service;

import com.crudapi.book.model.Book;
import com.crudapi.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService
{

    @Autowired
    public BookRepository bookRepository;

    @Override
    public List<Book> getAll()
    {
        return bookRepository.findAll() ;
    }

    @Override
    public Optional<Book> getById(Long id)
    {

        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getByTitle(String title) {

        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getByGenre(String genre) {

        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
}
