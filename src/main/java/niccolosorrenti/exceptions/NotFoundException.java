package niccolosorrenti.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int codiceISBN) {
        super("L'elemento catalogo con codice ISBN: " + codiceISBN + " non è stato trovato");
    }
}
