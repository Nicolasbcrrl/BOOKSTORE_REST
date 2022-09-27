package com.serverprogramming.bookstorev2.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {
    List<Book> findByIsbn(String isbn);
}
