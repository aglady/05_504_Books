package ru.gr05504.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BookService {
    private final BookRep rep;

    public BookService(BookRep rep){
    this.rep = rep;
    }
    public void addBook(String author, String title, String year, String info){
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException("Поле автора не может быть пустым");
        }
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Поле названия не может быть пустым");
        }
        if (year == null || year.isBlank()){
            throw new IllegalArgumentException("Поле год издания не может быть пустым");
        }
        int year_1;
        try {
            year_1 = Integer.parseInt(year);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Год издания должен быть числом", ex);
        }
        if (year_1 < 1000 || year_1 > LocalDateTime.now().getYear()){
            throw new IllegalArgumentException("Некорректный год");
        }
        var book = new Book(author, title, year_1, info);
        rep.save(book);

    }
    public List<Book> getAllBooks(){
        return rep.findAll();
    }
}
