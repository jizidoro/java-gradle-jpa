package com.comrades.app.persistence.repositories;

import com.comrades.app.domain.models.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository extends HashMapRepository<Book, Long> {

    public BookRepository() {
        super(Book.class);
    }

    @Override
    <S extends Book> Long getEntityId(S order) {
        return order.getId();
    }


    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {

    }
}
