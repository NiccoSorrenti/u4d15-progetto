package niccolosorrenti.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rivista")
public class Rivista extends Catalogo {

    @Enumerated(EnumType.STRING)
    @Column(name = "periodicità")
    private TipoRivista periodicità;

    protected Rivista() {

    }

    public Rivista(int codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, TipoRivista periodicità) {
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
