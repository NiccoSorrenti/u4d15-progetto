package niccolosorrenti.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import niccolosorrenti.entities.Catalogo;
import niccolosorrenti.entities.Libro;
import niccolosorrenti.exceptions.NotFoundAuthorExceptions;
import niccolosorrenti.exceptions.NotFoundTitleException;
import niccolosorrenti.exceptions.NotFoundYearException;

import java.util.List;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void aggiuntaElementoCatalogo(Catalogo elementoCatalogo) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(elementoCatalogo);

        transaction.commit();

        System.out.println("L'elemento catalogo " + elementoCatalogo + " è stato aggiunto correttamente");
    }

    public Catalogo ricercaPerISBN(int codiceISBN) {

        try {
            TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE c.codiceISBN = :isbn", Catalogo.class);
            query.setParameter("isbn", codiceISBN);
            Catalogo risultato = query.getSingleResult();
            System.out.println("Elemento con ISBN " + codiceISBN + " trovato");
            return risultato;
        } catch (NoResultException e) {
            System.out.println(e.getMessage() + codiceISBN);
            return null;
        }
    }

    public void rimozionePerISBN(int codiceISBN) {

        Catalogo found = ricercaPerISBN(codiceISBN);

        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();

            System.out.println("L'elemento con codice ISBN " + codiceISBN + " è stato eliminato con successo");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public List<Catalogo> ricercaPerAnno(int anno) throws NotFoundYearException {

        TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE c.annoPubblicazione = :anno", Catalogo.class);
        query.setParameter("anno", anno);
        List<Catalogo> risultato = query.getResultList();

        if (risultato.isEmpty()) {
            throw new NotFoundYearException(anno);
        }

        System.out.println("Elementi trovati per anno: " + anno);

        return risultato;
    }

    public List<Libro> ricercaPerAutore(String autore) throws NotFoundAuthorExceptions {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class);
        query.setParameter("autore", autore);
        List<Libro> risultato = query.getResultList();

        if (risultato.isEmpty()) {
            throw new NotFoundAuthorExceptions(autore);
        }

        System.out.println("L'elemento con autore " + autore + " è stato trovato");

        return risultato;
    }

    public List<Catalogo> ricercaPerTitolo(String titolo) throws NotFoundTitleException {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE c.titolo ILIKE :titolo", Catalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        List<Catalogo> risultato = query.getResultList();

        if (risultato.isEmpty()) {
            throw new NotFoundTitleException(titolo);
        }

        System.out.println("L'elemento con titolo " + titolo + " è stato trovato");

        return risultato;
    }
}
