package niccolosorrenti.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "libro")
public class Libro extends Catalogo {

    @Column(name = "autore")
    private String autore;

    @Column(name = "genere")
    private String genere;

    protected Libro() {

    }

    public Libro(int codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
