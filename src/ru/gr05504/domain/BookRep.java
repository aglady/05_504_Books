package ru.gr05504.domain;

import java.util.List;

public interface BookRep {
    void save(Book book);
    List<Book> findAll();
}
