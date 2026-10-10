import ru.gr05504.ui.*;

public class Main {

    public static void main(String[] args) {
        BookRep repository = new InMemoryBookRep();
        BookService service = new BookService(repository);
        BookPresenter presenter = new BookPresenter(service);
        var wnd = new Window(presenter);
        presenter.setView(wnd);
        wnd.setVisible(true);
        presenter.viewOpened();
    }
}
