package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IBookRepository {

    Optional<Book> findById(long id);

    void add(Book book);

    Collection<Book> getBooks();

    Page<Book> getBooks(Pageable pageable);
}
