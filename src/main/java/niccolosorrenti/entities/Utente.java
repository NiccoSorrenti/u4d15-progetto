package niccolosorrenti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue
    @Column(name = "utente_id")
    private UUID utenteId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @Column(name = "numero_di_tessera", unique = true, nullable = false)
    private int numeroDiTessera;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> listaPrestiti = new ArrayList<>();


    protected Utente() {

    }

    public Utente(String nome, String cognome, LocalDate dataDiNascita, int numeroDiTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTessera = numeroDiTessera;
    }

    public UUID getUtenteId() {
        return utenteId;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public int getNumeroDiTessera() {
        return numeroDiTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "utenteId=" + utenteId +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroDiTessera=" + numeroDiTessera +
                '}';
    }
}
