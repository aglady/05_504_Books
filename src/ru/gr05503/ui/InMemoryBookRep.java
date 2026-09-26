package ru.gr05503.ui;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRep implements  BookRep{

    private final List<Book> books = new ArrayList<>();
    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return List.copyOf(books);
    }
}
