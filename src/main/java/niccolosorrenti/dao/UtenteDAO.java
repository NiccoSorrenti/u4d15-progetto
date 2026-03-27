package niccolosorrenti.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import niccolosorrenti.entities.Utente;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaUtente(Utente nuovoUtente) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(nuovoUtente);

        transaction.commit();

        System.out.println("L'utente " + nuovoUtente + " è stato inserito con successo");
    }
}
