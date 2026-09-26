package ru.gr05503.ui;

import java.util.List;

public interface BookRep {
    void save(Book book);
    List<Book> findAll();
}
