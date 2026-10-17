package ru.gr05504.application;

import ru.gr05504.domain.Book;
import ru.gr05504.domain.BookRep;
import ru.gr05504.ui.ParsedBookInput;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

public class BookService {
    private final BookRep rep;
    private final Clock clock;

    public BookService(BookRep rep, Clock clock){
        this.rep = rep;
        this.clock = clock;
    }
    public void addBook(ParsedBookInput parsedBookInput){
        var author = parsedBookInput.author();
        var title = parsedBookInput.title();
        var year = parsedBookInput.year();
        var info = parsedBookInput.info();

        if (year > LocalDateTime.now(clock).getYear()){
            throw new IllegalArgumentException("Некорректный год");
        }
        var book = new Book(author, title, year, info);
        rep.save(book);

    }
    public List<Book> getAllBooks(){
        return rep.findAll();
    }
}
