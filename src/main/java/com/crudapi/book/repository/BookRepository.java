package com.crudapi.book.repository;

import com.crudapi.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>
{

    List<Book> findByTitle(String title);

    List<Book> findByGenre(String genre);

    List<Book> findByAuthor(String author);
}