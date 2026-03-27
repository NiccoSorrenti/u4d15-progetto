package niccolosorrenti.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import niccolosorrenti.entities.Catalogo;

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
}
