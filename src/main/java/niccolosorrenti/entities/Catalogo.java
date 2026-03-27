package niccolosorrenti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "codice_isbn", nullable = false, unique = true)
    private int codiceISBN;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "anno_pubblicazione")
    private LocalDate annoPubblicazione;

    @Column(name = "numero_pagine")
    private int numeroPagine;

    protected Catalogo() {

    }

    public Catalogo(UUID id, int codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        this.id = id;
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public UUID getId() {
        return id;
    }

    public int getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
