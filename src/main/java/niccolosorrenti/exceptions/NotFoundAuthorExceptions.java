package niccolosorrenti.exceptions;

public class NotFoundAuthorExceptions extends RuntimeException {
    public NotFoundAuthorExceptions(String autore) {
        super("L'autore " + autore + " non è stato trovato");
    }
}
