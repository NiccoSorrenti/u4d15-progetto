package niccolosorrenti.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Rivista extends Catalogo {

    @Column(name = "periodicità")
    private TipoRivista periodicità;

    protected Rivista() {

    }

    public Rivista(int codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine, TipoRivista periodicità) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public TipoRivista getPeriodicità() {
        return periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                '}';
    }
}
