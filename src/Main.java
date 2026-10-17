import ru.gr05504.application.BookService;
import ru.gr05504.domain.BookRep;
import ru.gr05504.infrastructure.InMemoryBookRep;
import ru.gr05504.ui.*;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) {
        BookRep repository = new InMemoryBookRep();
        Clock clock = Clock.systemDefaultZone();
//        Clock clock = Clock.fixed(
//                Instant.parse("2027-03-08T00:00:00Z"),
//                ZoneId.systemDefault()
//        );
        BookService service = new BookService(repository, clock);
        BookInputParser parser = new BookInputParser();
        BookPresenter presenter = new BookPresenter(service, parser);
        var wnd = new Window(presenter);
        presenter.setView(wnd);
        wnd.setVisible(true);
        presenter.viewOpened();
    }
}
