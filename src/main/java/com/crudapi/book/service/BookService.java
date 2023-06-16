package com.crudapi.book.service;

import com.crudapi.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService
{
    public List<Book> getAll();

    public Optional<Book> getById(Long id);

    public List<Book> getByTitle(String title);

    public List<Book> getByGenre(String genre);

    public List<Book> getByAuthor(String author);

}
