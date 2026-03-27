package niccolosorrenti.exceptions;

public class NotFoundYearException extends RuntimeException {
    public NotFoundYearException(int anno) {
        super("L'elemento con anno " + anno + " non è stato trovato");
    }
}
