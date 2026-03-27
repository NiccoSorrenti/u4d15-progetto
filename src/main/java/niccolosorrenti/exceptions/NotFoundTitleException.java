package niccolosorrenti.exceptions;

public class NotFoundTitleException extends RuntimeException {
    public NotFoundTitleException(String titolo) {
        super("L'elemento con titolo " + titolo + " non è stato trovato");
    }
}
