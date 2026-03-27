package niccolosorrenti.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import niccolosorrenti.entities.Prestito;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaPrestito(Prestito nuovoPrestito) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(nuovoPrestito);

        transaction.commit();

        System.out.println("Il prestito " + nuovoPrestito + " è stato aggiunto con successo");
    }

//    public List<Prestito> ricercaElementoInPrestito(int numeroTesseraUtente){
//
//        TypedQuery<Prestito> query = em.createQuery("SELECT u FROM Utente u WHERE u.numeroDiTessera = :numeroTesseraUtente")
//    }
}
