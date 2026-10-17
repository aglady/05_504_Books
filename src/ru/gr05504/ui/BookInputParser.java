package ru.gr05504.ui;

public class BookInputParser {
    public ParsedBookInput parse(
            String author, String title, String year, String info
    ) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Поле автора не может быть пустым");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Поле названия не может быть пустым");
        }
        return new ParsedBookInput(author,title,parseYear(year),info);
    }

    private int parseYear(String year) {
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
        return year_1;
    }
}
