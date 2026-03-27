package niccolosorrenti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestito")
public class Prestito {

    @Id
    @GeneratedValue
    @Column(name = "prestito_id")
    private UUID prestitoId;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_catalogo_id")
    private Catalogo elementoCatalogo;

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;

    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    protected Prestito() {

    }

    public Prestito(Utente utente, Catalogo elementoCatalogo, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoCatalogo = elementoCatalogo;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public UUID getPrestitoId() {
        return prestitoId;
    }

    public Utente getUtente() {
        return utente;
    }

    public Catalogo getElementoCatalogo() {
        return elementoCatalogo;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "prestitoId=" + prestitoId +
                ", utente=" + utente +
                ", elementoCatalogo=" + elementoCatalogo +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
